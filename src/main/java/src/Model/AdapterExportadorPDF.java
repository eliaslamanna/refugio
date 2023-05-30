package src.Model;

// Lo creamos porque la biblioteca de exportacion para pdf es muy probable que se cambie en un futuro
public interface AdapterExportadorPDF {
    String exportar(FichaMedica fichaMedica);
}
