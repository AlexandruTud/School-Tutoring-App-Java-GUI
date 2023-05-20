package emeditatii;

public class Request {
    private String requesterName;
    private String discipline;
    private String requestDate;
    private String requestTime;
    private String place;
    private String price;
    private boolean isAccepted;
    
    public Request(String requesterName,String discipline ,String requestDate, String requestTime, String place, String price, boolean isAccepted) {
      this.requesterName = requesterName;
      this.discipline= discipline;
      this.requestDate = requestDate;
      this.requestTime = requestTime;
      this.place = place;
      this.price = price;
      this.isAccepted=isAccepted;
    }
    
    public String getRequesterName() {
      return requesterName;
    }
    
    public void setRequesterName(String requesterName) {
      this.requesterName = requesterName;
    }
    public String getDiscipline() {
      return discipline;
    }
    
    public void setDiscipline(String discipline) {
      this.discipline= discipline;
    }
    
    public String getRequestDate() {
      return requestDate;
    }
    
    public void setRequestDate(String requestDate) {
      this.requestDate = requestDate;
    }
    
    public String getRequestHour() {
      return requestTime;
    }
    
    public void setRequestHour(String requestTime) {
      this.requestTime = requestTime;
    }
    
    public String getPlace() {
      return place;
    }
    
    public void setPlace(String place) {
      this.place = place;
    }
    
    public String getPrice() {
      return price;
    }
    
    public void setPrice(String price) {
      this.price = price;
    }
    public boolean getAccepted() {
      return isAccepted;
    }
    public void setIsAccepted(Boolean isAccepted){
      this.isAccepted=isAccepted;
    }
    
  }
