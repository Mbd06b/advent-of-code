package com.worscipe.aoc.one;

  
public class Password {

    private Integer minInstanceLimit;
    private Integer maxInstanceLimit;
    private Character keyChar;
    private String passString; 
    private Boolean isOccuranceValid;
    private Boolean isPositionValid;
    
    
    /**
     * 
     * @param string 
    * Input Examples:
    *    "2-4 r: prrmspx"
    *    "5-6 p: hpzplphxb"
    *    "55-87 t: ttttbtttttc"
     * @return
     */
    public static Password parsePassword(String str) {
        Password password = new Password(); 

        password.setMinInstanceLimit(Integer.valueOf(
            str.substring(
                0, 
                str.indexOf("-")
            )
        ));
        password.setMaxInstanceLimit(
            Integer.valueOf(
                str.substring( 
                    str.indexOf("-") + 1,
                    str.indexOf(" ")
                )
            )
        );
        password.setKeyChar(
            Character.valueOf(
                str.substring(
                    str.indexOf(" "),
                    str.indexOf(":")
                ).charAt(1)
            )
        );

        password.setPassString(
            str.substring(
                str.indexOf(":"),
                str.length()
            ).trim()
        );

        char[] charArray = password.getPassString().toCharArray();
        Integer count = 0;
        for(Character character: charArray){
            if(character.equals(password.getKeyChar())){
                 count = count + 1; 
            }
        }
        password.isOccuranceValid((count >= password.getMinInstanceLimit()  && count <= password.getMaxInstanceLimit() ));
        password.isPositionValid((
            password.getPassString().charAt(password.getMinInstanceLimit()+1) == (password.getKeyChar().charValue())
            ^ password.getPassString().charAt(password.getMaxInstanceLimit()+1) == (password.getKeyChar().charValue())
        ));
        return password;
    }
    
    public void setMinInstanceLimit(Integer num) {
        this.minInstanceLimit = num;
    }
    public Integer getMinInstanceLimit(){
        return this.minInstanceLimit;
    }
    public void setMaxInstanceLimit(Integer num){
        this.maxInstanceLimit = num;
    }
    public Integer getMaxInstanceLimit(){
        return this.maxInstanceLimit;
    }
    public void setKeyChar(Character keyChar){
        this.keyChar = keyChar;

    }
    public Character getKeyChar(){
        return this.keyChar;
    }
    public void setPassString(String passString){
        this.passString = passString;
    }
    public String getPassString(){
        return this.passString;
    }
    public void isOccuranceValid(Boolean isOccuranceValid){
        this.isOccuranceValid = isOccuranceValid;
    }
    public Boolean isOccuranceValid(){
        return this.isOccuranceValid;
    }
    public void isPositionValid(Boolean isPositionValid){
        this.isPositionValid = isPositionValid;
    }
    public Boolean isPositionValid(){
        return this.isPositionValid;
    }
}