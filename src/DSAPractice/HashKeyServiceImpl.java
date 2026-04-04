package DSAPractice;

public class HashKeyServiceImpl  {

    private String phoneNumber;

    private HashKeyServiceImpl(Builder builder) {
        this.phoneNumber = builder.phoneNumber;
    }

    public String checkValidMobileNumber(String phoneNumber) {
        if(phoneNumber.length() >= 10) {
            return "91" + phoneNumber.substring(phoneNumber.length()-10);
        }
        return phoneNumber;
    }

    public String getHashKey(String phoneNumber) {
        return "hello"+phoneNumber;
    }

    // Builder class
    public static class Builder {
        private String phoneNumber;

        public Builder() {
            // Initialize with default values if needed
        }

        public Builder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public HashKeyServiceImpl build() {
            return new HashKeyServiceImpl(this);
        }
    }

    public static void main(String[] args) {
        HashKeyServiceImpl build = new Builder().withPhoneNumber("123456789").build();
        String s = build.checkValidMobileNumber(build.phoneNumber);
        System.out.println(s);
        String hashKey = build.getHashKey(build.phoneNumber);
        System.out.println(hashKey);

    }
}
