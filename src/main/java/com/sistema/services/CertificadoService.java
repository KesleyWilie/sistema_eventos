package com.sistema.services;

import com.sistema.models.Inscricao;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CertificadoService {

    public void gerarCertificado(Inscricao inscricao) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Certificado de Participação");
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Participante: " + inscricao.getParticipante().getNome());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Evento: " + inscricao.getEvento().getTitulo());
                contentStream.newLineAtOffset(0, -20);
                contentStream.showText("Data: " + inscricao.getEvento().getData().toString());
                contentStream.endText();
            }

            document.save("certificado_" + inscricao.getParticipante().getId() + ".pdf");
        }
    }
}