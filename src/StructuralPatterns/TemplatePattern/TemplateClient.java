package StructuralPatterns.TemplatePattern;

public class TemplateClient {
    public static void main(String[] args) {
        ReportGenerator csvReport = new CSVReportGenerator();
        csvReport.generateReport();
        // Similarly for other report types
    }

}
