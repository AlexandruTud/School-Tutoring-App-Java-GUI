package emeditatii;

public class Review {
    private String reviewerName;
    private String rating;
    private String comment;
    private String discipline;
    
    public Review(String reviewerName,String rating, String comment, String discipline) {
      this.reviewerName = reviewerName;
      this.rating = rating;
      this.comment = comment;
      this.discipline = discipline;
    }
  
    public String getReviewerName() {
      return reviewerName;
    }
  
    public void setReviewerName(String reviewerName) {
      this.reviewerName = reviewerName;
    }
    public String getRating() {
        return rating;
      }
    
      public void setRating(String rating) {
        this.rating = rating;
      }
  
    public String getComment() {
      return comment;
    }
  
    public void setComment(String comment) {
      this.comment = comment;
    }
  
    public String getDiscipline() {
      return discipline;
    }
  
    public void setDiscipline(String discipline) {
      this.discipline = discipline;
    }
  }