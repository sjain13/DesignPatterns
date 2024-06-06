package StructuralPatterns.TemplatePattern;

public abstract class ReportGenerator {
    protected abstract String collectData();
    protected abstract String processData(String data);
    protected abstract String formatReport(String processedData);

    private void printReport(String report) {
        System.out.println(report);
    }

    public void generateReport() {
        String data = collectData();
        String processedData = processData(data);
        String report = formatReport(processedData);
        printReport(report);
    }

}
