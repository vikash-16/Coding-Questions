package DSAPractice;

public class CommonPractice {
    public static void main(String[] args) {
        String [] s = {"vikash choudhary 5 5 6","ethan wyatt 8 9 10"};
        System.out.println(new CommonPractice().solution(s));
    }

    private String solution(String[] s) {
        StringBuilder result = new StringBuilder();
        for(String str : s) {
            String[] split = str.split("[ ]");
            int count = 0;
            int sum = 0;
            Boolean isdigit = false;
            for(String string : split) {
                char[] array = string.toCharArray();
                if(Character.isDigit(array[0])) {
                    isdigit = true;
                    Integer i = Integer.valueOf(string);
                    if(i <= 10) {
                        sum+=i;
                        count++;
                    }
                }else {
                    result.append(string);
                    if(!isdigit)
                        result.append(" ");
                }
            }
            if (isdigit) {
                result.deleteCharAt(result.length()-1);
                result.append("-");
                int ceil = (int) Math.ceil(sum / count);
                result.append(ceil);
                result.append(";");
            }
        }
        return result.toString();
    }

}
