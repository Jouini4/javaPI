/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shahba.UI.front;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
//import javax.mail.Authenticator;
//import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PageArticleController implements Initializable {

    @FXML
    private Label lab_tit;

    @FXML
    private Label lab_cat;
    @FXML
    private Label lab_desc;

    @FXML
    private Label lab_like;
    private Rating rateUs;
    @FXML
    private Label lab_img;
    @FXML
    private StackPane sp;
    @FXML
    private ImageView imview;
    @FXML
    private Rating rate;
    @FXML
    private Button ratebouton;
    @FXML
    private Label msg;

    public void setLab_tit(String titre_art) {
        this.lab_tit.setText(titre_art);

    }


    public void setLab_img(String description_art) {
        this.lab_img.setText(description_art);
    }

    public void setLab_cat(String nomcat) {
//        this.lab_cat = lab_cat;
        this.lab_cat.setText(nomcat);
    }


    public void setLab_desc(String cat_desc) {
//        this.cat_desc = cat_desc;
        this.lab_desc.setText(cat_desc);
    }

    public void setLab_like(String likes) {
//        this.lab_like = lab_like;
        this.lab_like.setText(likes);
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
       rate.ratingProperty().addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
            msg.setText("Avis : "+newValue);
    });
    }

    @FXML
    private void backtomenu(ActionEvent event) throws IOException {
        Parent rootRec2 = FXMLLoader.load(getClass().getResource("Homefront.fxml"));
        Scene rec2 = new Scene(rootRec2);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(rec2);
        app.show();
    }

    @FXML
    public void tes(ActionEvent event) throws IOException {
        Parent rootRec2 = FXMLLoader.load(getClass().getResource("test1.fxml"));
        Scene rec2 = new Scene(rootRec2);
        Stage app = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app.setScene(rec2);
        app.show();
    }

    @FXML
    private void CreatePDF(ActionEvent event) throws SQLException, DocumentException {
        try {

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\khawl\\Desktop\\Nouveau dossier\\Shahba33\\src\\pdf\\Article.pdf"));
            doc.open();
//       
////       Image img = Image.getInstance("C:\\Users\\ASuS\\Documents\\NetBeansProjects\\PI_Salma\\PI\\src\\com\\spirity\\img\\spirity.png");
////       img.scaleAbsoluteHeight(60);
////       img.scaleAbsoluteWidth(100);
////       img.setAlignment(Image.ALIGN_RIGHT);
////       doc.add(img);
//       
            doc.add(new Paragraph(" "));
            Font font = new Font(FontFamily.TIMES_ROMAN, 28, Font.UNDERLINE, BaseColor.RED);
            Paragraph p = new Paragraph("Article converti en PDF", font);
            p.setAlignment(Element.ALIGN_CENTER);

            doc.add(p);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));

            PdfPTable tabpdf = new PdfPTable(6);
            tabpdf.setWidthPercentage(100);

            PdfPCell cell;
            cell = new PdfPCell(new Phrase("Nom Produit", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("Image", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("Prix", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("Description", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("Catégorie", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            cell = new PdfPCell(new Phrase("Like", FontFactory.getFont("Times New Roman", 11)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.WHITE);
            tabpdf.addCell(cell);

            tabpdf.addCell(lab_tit.getText());
            tabpdf.addCell(lab_desc.getText());
            tabpdf.addCell(lab_cat.getText());
            tabpdf.addCell(lab_img.getText());

            doc.add(tabpdf);
            JOptionPane.showMessageDialog(null, "Success !!");
            doc.close(); //com.spirity.pdf C:\Users\ASUS\Documents\NetBeansProjects\PII\src\com\spirity\pdf
            Desktop.getDesktop().open(new File("C:\\Users\\khawl\\Desktop\\Nouveau dossier\\Shahba33\\src\\pdf\\Article.pdf"));

        } catch (DocumentException | HeadlessException | IOException e) {
            System.out.println("ERROR PDF");
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void Rating(ActionEvent event) {
//        System.out.println("Rating given by user : " + rateUs.getRating());
        JOptionPane.showMessageDialog(null, "Thanksss for rating us ☺ !!");
}

    public void load_pic(String links) {

        Image img = new Image(links);

       /* sp.setMaxSize(img.getWidth(), img.getHeight());
        sp.setPrefSize(img.getWidth(), img.getHeight());

        imview.setFitHeight(img.getHeight());
        imview.setFitWidth(img.getWidth());*/
        imview.setImage(img);

    }

}
