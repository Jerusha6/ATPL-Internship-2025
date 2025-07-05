class SystemUtils{
static class Logger{
    int p=0;
    void setPendings(int p){
        this.p=p;
    }
     void getStatus(){
    if(p>0){
        System.out.println(p+" Tasks are still pending");
    }
    else{
        System.out.println("Nothing is pending");
    }
    }
}
}
class LoggerCls {
    public static void main(String[] args){
        // SystemUtils su = new SystemUtils();
        SystemUtils.Logger log = new SystemUtils.Logger(); 
        log.getStatus();
        log.setPendings(5);
        log.getStatus();
    }
}
