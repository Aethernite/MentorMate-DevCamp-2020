public class Main {
    private final String input = "mentormate";


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start(){
        String converted = convertStringToBinary(input);
        System.out.println(converted);
    }

    public String convertStringToBinary(String str){
        StringBuilder converted = new StringBuilder();
        char[] inputChar = str.toCharArray();

        for (char c : inputChar) {
            converted.append(
                    String.format("%8s", Integer.toBinaryString(c))
                            .replace(" ", "0")
            );
        }

        return converted.toString();
    }
}
