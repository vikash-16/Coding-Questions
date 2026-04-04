//package com.prisyn.dafitotp.handler;
//
//import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
//
//import com.amazonaws.services.lambda.runtime.Context;
//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.Filters;
//import com.prisyn.dafitotp.dto.Response;
//import com.prisyn.dafitotp.util.OtpGenerator;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZonedDateTime;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.UUID;
//import java.util.concurrent.CompletableFuture;
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.bson.Document;
//import org.json.JSONObject;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
//import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
//import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
//import software.amazon.awssdk.utils.StringUtils;
//
//public class OtpRequestHandler {
//
//    public final Integer OTP_LENGTH = 4;
//    private final String MOBTEXT_URL;
//    private final String MOBTEXT_TEMPLATE_ID;
//    private final String KARIX_URL;
//    private final String KARIX_FROM;
//    private final String KARIX_TOKEN;
//    private final String KARIX_TEMPLATE;
//    private final MongoClient mongoClient;
//    private final MongoDatabase database;
//    private final MongoCollection<Document> otpCollection;
//    private final MongoCollection<Document> commonData;
//    private final MongoCollection<Document> whatsappOtpStatus;
//    private final MongoCollection<Document> otpStatus;
//    private final RestTemplate restTemplate;
//
//    public OtpRequestHandler() {
//        String SECRET_MANAGER_NAME = "Beatxp-common-creds";
//
//        try (SecretsManagerClient client =
//                     SecretsManagerClient.builder().region(Region.AP_SOUTH_1).build()) {
//
//            GetSecretValueRequest getSecretValueRequest =
//                    GetSecretValueRequest.builder().secretId(SECRET_MANAGER_NAME).build();
//            GetSecretValueResponse secretValue = client.getSecretValue(getSecretValueRequest);
//
//            if (secretValue.secretString() == null) {
//                throw new RuntimeException("Secret value cannot be null.");
//            }
//
//            JSONObject jsonObject = new JSONObject(secretValue.secretString());
//            String url = (String) jsonObject.get("MONGODB_URI_JAVA_DAFIT");
//
//            this.mongoClient = MongoClients.create(url);
//            this.database = this.mongoClient.getDatabase("DaFit_SmartWatch");
//            this.otpCollection = database.getCollection("OTP");
//            this.otpStatus = database.getCollection("OTPStatus");
//            this.commonData = database.getCollection("CommonData");
//            this.whatsappOtpStatus = database.getCollection("WhatsappOtpStatus");
//
//            this.restTemplate = new RestTemplate();
//
//            Document requestBody =
//                    this.commonData.find(Filters.eq("name", "KarixOTPRequestBody")).first();
//            Objects.requireNonNull(requestBody, "Request body cannot be null.");
//
//            this.MOBTEXT_URL = jsonObject.getString("MOBTEXT_URL");
//            this.MOBTEXT_TEMPLATE_ID = jsonObject.getString("MOBTEXT_TEMPLATE_ID");
//            this.KARIX_URL = jsonObject.getString("KARIX_URL");
//            this.KARIX_FROM = jsonObject.getString("KARIX_FROM");
//            this.KARIX_TOKEN = "Bearer " + jsonObject.getString("KARIX_TOKEN");
//            this.KARIX_TEMPLATE = (String) requestBody.get("value");
//        }
//    }
//
//    public ResponseEntity<Response> handleRequest(Map<String, String> body, Context ignored) {
//        String generateOtp = OtpGenerator.generateOtp(this.OTP_LENGTH);
//
//        // TODO: to be implemented later.
//    /*
//    Document smsVendor = this.commonData.find(Filters.eq("name", "smsVendor")).first();
//    Document whatsappVendor = this.commonData.find(Filters.eq("name", "whatsappVendor")).first();
//    Objects.requireNonNull(smsVendor, "SMS vendor not found.");
//    Objects.requireNonNull(whatsappVendor, "WhatsApp vendor not found.");
//    */
//
//        String mobileNumber = body.get("mobileNumber");
//
//        this.sendWhatsappFromKarix(mobileNumber, generateOtp);
//        Map<String, Boolean> response = this.callMobTextAPI(mobileNumber, generateOtp);
//
//        if (response.get("success")) {
//            this.insertOTPInDB(generateOtp, mobileNumber);
//            return ResponseEntity.ok(new Response("Success", "OTP sent successfully.", null));
//        }
//        return ResponseEntity.internalServerError()
//                .body(new Response("Failed", "OTP sending failed.", null));
//    }
//
//    public Map<String, Boolean> callMobTextAPI(String mobile, String otp) {
//        Map<String, Boolean> result = new HashMap<>();
//        result.put("success", false);
//        try {
//            List<String> variables = new ArrayList<>();
//            variables.add(otp);
//
//            Map<String, Object> body = new HashMap<>();
//            body.put("to", mobile);
//            body.put("service", "T");
//            body.put("template_id", this.MOBTEXT_TEMPLATE_ID);
//            body.put("variables", variables);
//
//            Map<String, Object> mobTextResponse =
//                    (Map<String, Object>) restTemplate.postForObject(this.MOBTEXT_URL, body, Map.class);
//            assert mobTextResponse != null;
//            System.out.println("MobText response: " + mobTextResponse.toString());
//
//            CompletableFuture.runAsync(
//                    () ->
//                            createMobileOTPStatusInDB(
//                                    Objects.requireNonNull(mobTextResponse, "MobText response cannot be null.")));
//
//            result.put("success", true);
//            return result;
//        } catch (Exception exception) {
//            System.out.println("MobText exception: " + ExceptionUtils.getStackTrace(exception));
//        }
//        return result;
//    }
//
//    private void createMobileOTPStatusInDB(Map<String, Object> mobTextResponse) {
//        List<Map<String, Object>> data = (List<Map<String, Object>>) mobTextResponse.get("data");
//        Map<String, Object> smsData = data.get(0);
//
//        Document otpStatus = new Document();
//        otpStatus.put("serviceProviderId", smsData.get("id"));
//        otpStatus.put("status", smsData.get("status"));
//        otpStatus.put("mobile", smsData.get("mobile"));
//        otpStatus.put("vendor", "MobText");
//        otpStatus.put("statusHistory", List.of((String) smsData.get("status")));
//        otpStatus.put("submittedAt", smsData.get("submitted_at"));
//        otpStatus.put("createdAt", LocalDateTime.now());
//        otpStatus.put("updatedAt", LocalDateTime.now());
//
//        this.otpStatus.insertOne(otpStatus);
//    }
//
//    private void sendWhatsappFromKarix(String mobile, String otp) {
//        String requestBody = String.valueOf(this.KARIX_TEMPLATE);
//        requestBody = requestBody.replace("{{otp}}", otp);
//        requestBody = requestBody.replace("{{mobile}}", mobile);
//
//        Map<String, Object> response = this.sendWhatsapp(requestBody);
//
//        if (StringUtils.isNotBlank((String) response.get("exception"))) {
//            throw new RuntimeException(String.format("Karix API failed: %s", response.get("exception")));
//        }
//
//        CompletableFuture.runAsync(
//                () ->
//                        this.createWhatsappOTPStatusInDB(
//                                (String) response.get("mid"), mobile, "Queue", ZonedDateTime.now(), "Karix"));
//    }
//
//    private Map<String, Object> sendWhatsapp(String body) {
//        body = body.replace("{{from}}", "918588983445");
//        Map<String, Object> result = new HashMap<>();
//        try {
//            HttpResponse<JsonNode> response =
//                    Unirest.post(this.KARIX_URL)
//                            .header("Authentication", this.KARIX_TOKEN)
//                            .header(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                            .body(body)
//                            .asJson();
//
//            JSONObject responseObject = response.getBody().getObject();
//            System.out.println("WhatsApp response: " + responseObject.toString());
//
//            if (!responseObject.getString("statusCode").equals(String.valueOf(HttpStatus.OK.value()))) {
//                result.put("exception", responseObject.toMap());
//            } else {
//                String mid = (String) Objects.requireNonNull(response.getBody()).getObject().get("mid");
//                result.put("mid", mid);
//            }
//        } catch (Exception exception) {
//            String stackTrace = ExceptionUtils.getStackTrace(exception);
//            System.out.println("WhatsApp exception: " + stackTrace);
//            result.put("exception", stackTrace);
//        }
//        return result;
//    }
//
//    private void insertOTPInDB(String generateOtp, String mobileNumber) {
//        Document otp = new Document();
//        otp.put("_id", UUID.randomUUID().toString());
//        otp.put("otp", generateOtp);
//        otp.put("mobileNumber", mobileNumber);
//        otp.put("createdAt", LocalDateTime.now());
//        otp.put("updatedAt", LocalDateTime.now());
//
//        this.otpCollection.insertOne(otp);
//    }
//
//    private void createWhatsappOTPStatusInDB(
//            String mid, String to, String status, ZonedDateTime dateSent, String vendor) {
//        Document whatsappOtpStatus = new Document();
//        whatsappOtpStatus.put("_id", UUID.randomUUID().toString());
//        whatsappOtpStatus.put("messageId", mid);
//        whatsappOtpStatus.put("status", status);
//        whatsappOtpStatus.put("mobile", to);
//        whatsappOtpStatus.put("vendor", vendor);
//        whatsappOtpStatus.put(
//                "submittedAt", dateSent.withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
//        whatsappOtpStatus.put("statusHistory", List.of(status));
//        whatsappOtpStatus.put("createdAt", LocalDateTime.now());
//        whatsappOtpStatus.put("updatedAt", LocalDateTime.now());
//
//        this.whatsappOtpStatus.insertOne(whatsappOtpStatus);
//    }
//}