package emeditatii;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterRequests {
  
  public void registerRequest(String fileName, Request request) throws IOException {
    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
    writer.write(request.getRequesterName()+","+request.getDiscipline()+","+request.getRequestDate()+","+request.getRequestHour()+","+request.getPlace()+","+request.getPrice()+","+request.getAccepted());
    writer.newLine();
    writer.close();
    }
}