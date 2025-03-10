public class Answers {
    private int questionNum, ans;
    private String letter;
    private boolean correct;

    public Answers (int questionNum, String letter, boolean correct, int ans){
        this.questionNum = questionNum;
        this.letter = letter;
        this.correct = correct;
        this.ans = ans;
    }

    public void setQuestionNum(int num){
        this.questionNum = num;
    }
    public void setCorrect (boolean correct){
        this.correct = correct;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
