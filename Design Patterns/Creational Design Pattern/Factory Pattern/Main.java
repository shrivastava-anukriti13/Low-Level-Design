class Main{
    public static void main(String[] args){
        LogisticsService logisticsService = new LogisticsService();
        logisticsService.send("Air");
        logisticsService.send("Road");
    }
}