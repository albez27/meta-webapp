package albez.metawebapp;

import java.util.HashMap;

public class RobotFields {
    private String tomcat;
    private String type;
    private String oldAtr;
    private String newAtr;
    private String block;
    private String ids;
    private String reverse;
    private String needChainy;
    private String needCheck;
    private String needArray;
    private String needEdit;
    private final String receiver =  "copyoldatr2newatr@bgoperator.com";
    private StringBuilder com;
    public RobotFields(HashMap<String,String> data){
        this.tomcat = data.get("tomcat");
        this.type = data.get("fltType");
        this.oldAtr = data.get("oldAtr");
        this.newAtr = data.get("newAtr");
        this.block = data.get("block").equals("") ? "0" : data.get("block");
        this.ids = data.get("ids").equals("") ? "0" : data.get("ids");
        this.reverse = data.get("reverse").equals("") ? "0" : "1";
        this.needChainy = data.get("chainy").equals("") ? "0" : "1";
        this.needCheck = data.get("needCheck").equals("") ? "0" : "1";
        this.needArray = data.get("needArray").equals("") ? "0" : "1";
        this.needEdit = data.get("needEdit").equals("") ? "0" : "1";
    }
    public String getCom(){
        StringBuilder com = new StringBuilder();
        com.append("/usr/java/jdk1.7.0_80/bin/java -cp /w2/srv/tomcat" + tomcat
                + "/webapps/bg/WEB-INF/classes:/w2/srv/tomcat" + tomcat
                + "/lib/:/w2/srv/tomcat" + tomcat + "/lib/*:/w2/srv/tomcat"
                + "/webapps/bg/WEB-INF/lib/* util.Robot bg_main co_bg CopyOldAtr2NewAtr "
                + type + " " + oldAtr + " " + newAtr + " " + block + " " + ids + " " + reverse
                + " " + needChainy + " " + needCheck + " " + needArray + " " + needEdit + " " + receiver);
        return com.toString();
    }

}
