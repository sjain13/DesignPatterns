package StructuralPatterns.TemplatePattern;

public class CSVReportGenerator extends ReportGenerator {

    @Override
    protected String collectData() {
        return "CSV Data";
    }

    @Override
    protected String processData(String data) {
        return "Processed " + data;
    }

    @Override
    protected String formatReport(String processedData) {
        return "CSV Report: " + processedData;
    }

}


// Similar classes for HTMLReportGenerator and PDFReportGenerator