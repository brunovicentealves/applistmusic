package com.bruno.listmusic.listMusic.util;

import com.bruno.listmusic.listMusic.domain.Playlist;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class GeneratePdfReportPlayList  {
    private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReportPlayList.class);

    public static ByteArrayInputStream citiesReport(List<Playlist> playlists) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();


        try {


            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(80);
            table.setWidths(new int[] { 1, 3, 3 });

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

            PdfPCell hcell;
            hcell = new PdfPCell(new Phrase("id", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("nome", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("descrição", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            for (Playlist playlist : playlists) {

                PdfPCell cell;

                cell = new PdfPCell(new Phrase(String.valueOf(playlist.getId())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(playlist.getNome()));
                cell.setPaddingLeft(5);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(playlist.getDescricao())));
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setPaddingRight(5);
                table.addCell(cell);
            }

            PdfWriter.getInstance((com.itextpdf.text.Document) document, out);
            ((com.itextpdf.text.Document) document).open();
            Paragraph pTitulo = new Paragraph(new Phrase(30F , "Lista de Playlists", FontFactory.getFont(FontFactory.HELVETICA, 18F)));
            pTitulo.setAlignment(Element.ALIGN_CENTER);
            pTitulo.setSpacingAfter(20);

            document.add( pTitulo );


            ((com.itextpdf.text.Document) document).add(table);

            ((com.itextpdf.text.Document) document).close();

        } catch (DocumentException ex) {

            logger.error("Error occurred: {0}", ex);
        }

        return new ByteArrayInputStream(out.toByteArray());
    }


}
