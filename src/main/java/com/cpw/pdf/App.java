package com.cpw.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Hello world!
 *
 */
public class App 
{
	public static PdfPCell createImageCell(String path) throws DocumentException, IOException {
        Image img = Image.getInstance(path);
        PdfPCell cell = new PdfPCell(img, true);
        return cell;
    }
	
	static Image IMG1 = null;
	
    public static void main( String[] args )
    {
    	createPdf("abc");
   }
    public static void createPdf( String args )
    {
        System.out.println( "Hello World!" );
        Document document = new Document();//PageSize.A4.rotate()
        try {
        	try {
				IMG1 = Image.getInstance("F:\\dev\\final\\cpw\\capture.jpg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PdfWriter.getInstance(document, new FileOutputStream("ttsplBL.pdf"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String shipperAddress = "CAMBRIDGE TIME SPARES\n79 EBRAHIM REHMATULLA ROADMUMBAI 400\n003 (INDIA)TEL 009123736325 FAX\n00912223738723";
        String multimodalTransportDocumentRegNo = "";
        String shippersRefernce ="Shipper's Refernce";
        String consigneeDetail = "Consignee (if 'To Order' as indicate)";
        String consigneeDetail2 = "TO THE ORDER OF SHIPPER";
        String notifyParty = "Notify Party(No Claim shall attach for failure to notify)";
        String placeOfRec ="    Place of Received";
        String placeOfRecName ="";
        String portOfLoading = "    Port of Loading";
        String portOfLoadingName = "";
        String vessel = "    Vessel";
        String vesselName = "";
        String portOfDischarge ="    Port of Discharge";
        String portOfDischargeName = "";
        String freightPayable = "    Freight Payable at :";
        String freightPayableAt = "";
        String placeOfDelivery = "    Place of Deliver";
        String placeOfDeliveryName = "";
        String noOfOriginalBillsOfLading = "    No. of Original Bills of Lading";
        String marksAndNumber = "Marks and Number";
        String descriptionOfGoods = "Number and Kind of Packeges/Description of goods"; 
        String grossWeight ="Gross Weight";
        String measurement = "Measurement";
        String measurementData = "";
        String netWeight  ="Net Weight";
        String netWeightData = ""; 
        String shippingBillDetails = "Shipping Bill Details : ";
        String placeAndDateOfIssue = "\n\n\nPlace and date of issue  --------------------------------------    \n\n For\n\n\n\n\n";
        String authorizedSignatory = "Authorized Signatory\n\n";
        document.open();
        Font font = FontFactory.getFont(FontFactory.TIMES, 6);
        PdfPTable table = new PdfPTable(8);
        //table.setWidths(new int[]{ 4, 4, 4, 4});
        table.setWidthPercentage(100);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Top1 Left\n\n\n\n\n\n"));
        cell.setRowspan(6);
        cell.setColspan(4);
        Paragraph shipper = new Paragraph("Shipper\n\n\n\n\n\n", font);
        shipper.setAlignment(Element.ALIGN_TOP);
        cell.addElement(shipper);
        table.addCell(cell);//r-8,c-2
        cell = new PdfPCell(new Phrase("Multimodal Transport Document Registration No. ", font));
        cell.setColspan(4);
        table.addCell(cell);//c-2
        cell = new PdfPCell(new Phrase("Multimodal Transport Document Registration No. ", font));
        cell.setColspan(4);
        table.addCell(cell);//c-2
        cell = new PdfPCell(new Phrase(shippersRefernce,font));
        cell.setColspan(4);
        table.addCell(cell);//c-2
        cell = new PdfPCell(new Phrase("Top Right-1\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));
        cell.setColspan(4);
        cell.setRowspan(15);
       // IMG1.getCompressionLevel();//setAutoScaleHeight(false);
        IMG1.setWidthPercentage(0);
        Phrase listOfDots = new Phrase();
        listOfDots.add(new Chunk(IMG1, 75, 0));
        listOfDots.add(new Chunk(" "));
        cell.addElement(listOfDots);
        //cell.addElement(IMG1);
        Font companyAddress1 = FontFactory.getFont(FontFactory.TIMES, 12, Font.BOLD);
        Paragraph p = new Paragraph("TOTAL TRANSPORT SYSTEMS LIMITED", companyAddress1);
        p.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(p);
        Font companyAddress2 = FontFactory.getFont(FontFactory.TIMES, 7);
        Paragraph p2 = new Paragraph("701-705, T Square, Opp. Chandivali Petrol Pump, Saki-Vihar Road,\n"
        		+ "Sakinaka, Andher (E), Mumbai 400 072, INDIA\n"
        		+ "Tel. : +91-22-66441500 Fax : +91-22-66441585\n"
        		+ "Email : info@cpworldindia.com\n\n",companyAddress2);
        p2.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(p2);
        
        Font companyAddress3 = FontFactory.getFont(FontFactory.TIMES, 11);
        Paragraph p3 = new Paragraph("Regn. No : MTO/DGS/1226/NOV/2016\n", companyAddress3);
        p3.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(p3);
        
        Font companyAddress4 = FontFactory.getFont(FontFactory.TIMES, 10, Font.BOLD);
        Paragraph p4 = new Paragraph("NON-NEGOTIABLE\n", companyAddress4);
        p4.setAlignment(Element.ALIGN_CENTER);
        cell.addElement(p4);
        
        table.addCell(cell);//c-2
        
        cell = new PdfPCell(new Phrase("Top Left1\n\n\n\n\n\n"));
        cell.setRowspan(6);
        cell.setColspan(4);
        
        Paragraph consigneeDetailPara = new Paragraph(consigneeDetail+"\n\n", font);
        shipper.setAlignment(Element.ALIGN_TOP);
        cell.addElement(consigneeDetailPara);
        Paragraph consigneeDetailPara2 = new Paragraph("\t"+consigneeDetail2+"\n\n\n", companyAddress4);
        shipper.setAlignment(Element.ALIGN_TOP);
        cell.addElement(consigneeDetailPara2);
        table.addCell(cell);//r-8,c-2
        cell = new PdfPCell(new Phrase("Top Left2\n\n\n\n"));
        cell.setRowspan(6);
        cell.setColspan(4);
        Paragraph notifyPartyPara = new Paragraph(notifyParty+"\n\n", font);
        notifyPartyPara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(notifyPartyPara);
        table.addCell(cell);//r-8,c-2
             
        cell = new PdfPCell(new Phrase("Top Right11\n Test"));
        cell.setRowspan(2);
        cell.setColspan(2);
        Paragraph placeOfRecPara = new Paragraph(placeOfRec+"\n", font);
        placeOfRecPara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(placeOfRecPara);
        table.addCell(cell);//c-2
        cell = new PdfPCell(new Phrase("Top Right12\n Test"));
        cell.setRowspan(2);
        cell.setColspan(2);
        Paragraph portOfLoadingPara = new Paragraph(portOfLoading+"\n", font);
        portOfLoadingPara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(portOfLoadingPara);
        table.addCell(cell);//c-2
        
        cell = new PdfPCell(new Phrase("Top Right13\n Test"));
        cell.setRowspan(2);
        cell.setColspan(4);
        Paragraph freightPayablePara = new Paragraph(freightPayable+"\n", font);
        freightPayablePara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(freightPayablePara);
        
        table.addCell(cell);//c-2
      
        cell = new PdfPCell(new Phrase("Top Right15\n Test"));
        cell.setRowspan(2);
        cell.setColspan(2);
        Paragraph vesselPara = new Paragraph(vessel+"\n", font);
        vesselPara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(vesselPara);
        table.addCell(cell);//c-2
        cell = new PdfPCell(new Phrase("Top Right16\n Test"));
        cell.setRowspan(2);
        cell.setColspan(2);
        Paragraph portOfDischargePara = new Paragraph(portOfDischarge+"\n", font);
        portOfDischargePara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(portOfDischargePara);
        table.addCell(cell);//c-2
        
        cell = new PdfPCell(new Phrase("Top Right17\n Test"));
        cell.setRowspan(2);
        cell.setColspan(2);
        Paragraph placeOfDeliveryPara = new Paragraph(placeOfDelivery+"\n", font);
        placeOfDeliveryPara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(placeOfDeliveryPara);
        table.addCell(cell);//c-2
        cell = new PdfPCell(new Phrase("Top Right18\n Test"));
        cell.setRowspan(2);
        cell.setColspan(2);
        Paragraph noOfOriginalBillsOfLadingPara = new Paragraph(noOfOriginalBillsOfLading+"\n", font);
        noOfOriginalBillsOfLadingPara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(noOfOriginalBillsOfLadingPara);
        table.addCell(cell);//c-2
        
        cell = new PdfPCell(new Phrase("Top Left\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"));
        cell.setRowspan(20);
        cell.setColspan(8);
        table.addCell(cell);//r-8,c-2
        
        cell = new PdfPCell(new Phrase("In accepting this bill of lading. The Merchant expressly to be bound by all be terms, condition, clauses and exceptions on\n"
        		+ " both sides of the bill of lading whether types, printed or otherwise.  For Freight prepaid bill of lading, delivery of Cargo is\n"
        		+ " subject to realisation of freight cheque.  (Above particulars as declared by shipper)\n\n\n", font));
        cell.setRowspan(3);
        cell.setColspan(5);
        table.addCell(cell);//c-2
        
        cell = new PdfPCell(new Phrase("Top Right16\n\n\n"));
        cell.setRowspan(9);
        cell.setColspan(3);
        
        Paragraph placeAndDateOfIssuePara = new Paragraph(placeAndDateOfIssue+authorizedSignatory+"\n", font);
        placeAndDateOfIssuePara.setAlignment(Element.ALIGN_TOP);
        cell.addElement(placeAndDateOfIssuePara);
        table.addCell(cell);//c-2
        cell = new PdfPCell(new Phrase("Takes in charge in apparently good condition herein at the receipt for transport and delivery as mentioned above, unless\n"
        		+ "otherwise stated. The MTO accordance with the provisions contained in the MTD undertakes to perform or the performance\n"
        		+ "of the multimodal transport from the place at which the goods are taken in charges, to place designated for delivery and\n"
        		+ "assumes responsibility for such transport. One of the MTD must be surrounded, duty endorsed in exchange for the goods.\n"
        		+ "In witness where of the original MTD all of this tenor and date have been signed in the number indicated below one of which\n"
        		+ "being accomplished the other(s) to be void. Terms and condition overleaf. Demurrage/ Detention charges at port of\n"
        		+ "destination payable by consignee as per line tariff. No of packages mentioned above, have been received in apparent good\n"
        		+ "condition, carriers does not certify the contents of the packages and is not responsible for any shortages there in. By\n"
        		+ "accepting this bill of lading, the shipper accepts his responsibility towards the carrier for payment of freight (in case of freight\n"
        		+ "collect shipment), accrued Ground rent, reshipment or disposal costs (as the case may be) if the consignee fails to take\n"
        		+ "delivery of cargo within 90 days from the date cargo reached destination. The carrier reserves the right to repack the goods\n"
        		+ "if the same are not in seaworthy. The packing condition will be certified by the local bonded warehouse or competent\n"
        		+ "surveyor, and the shipper by virtue of accepting this bill landing accepts the liability towards the cost for the same.", font));
        cell.setRowspan(6);
        cell.setColspan(5);
        table.addCell(cell);//c-2
                
        Paragraph paragraph1 = new Paragraph("BILL OF LADING\n");
        document.add(paragraph1);
        Paragraph paragraph2 = new Paragraph("\n");
        document.add(paragraph2);
        document.add(table);
        document.close();
    }

}
