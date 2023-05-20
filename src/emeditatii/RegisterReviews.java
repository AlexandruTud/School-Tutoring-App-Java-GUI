package emeditatii;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterReviews {
    public void RegisterRev(String fileName, Review review) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(review.getReviewerName()+","+review.getRating()+","+review.getComment()+","+review.getDiscipline());
        writer.newLine();
        writer.close();
        }
}
