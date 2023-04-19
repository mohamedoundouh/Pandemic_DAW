import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class parametros {

	public static void main(String[] args) {
	    // Inicializar Scanner para leer la entrada del usuario
	    Scanner scanner = new Scanner(System.in);

	    // Nombre del archivo XML con los parámetros del juego
	    String fileName = "C:\\Users\\Mohamed\\Documents\\GitHub\\Pandemic_DAW\\Pandemic_DAW\\src\\parametros.xml";
	    
	    // Crear objeto DocumentBuilderFactory para obtener un objeto DocumentBuilder
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

	    try {
	        // Crear objeto DocumentBuilder a partir del objeto DocumentBuilderFactory
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        // Leer el archivo XML y parsearlo en un objeto Document
	        Document document = builder.parse(new File(fileName));
	        // Normalizar el Document para asegurar la coherencia de los datos
	        document.getDocumentElement().normalize();

	        // Variable booleana para controlar el flujo del programa
	        boolean salir = false;
	        while (!salir) {
	            // Mostrar el menú de opciones
	            System.out.println("\nMENU");
	            System.out.println("1. Mostrar parametros");
	            System.out.println("2. Modificar parametros");
	            System.out.println("3. Salir");
	            System.out.print("Elija una opcion: ");

	            // Leer la opción seleccionada por el usuario
	            int opcion = scanner.nextInt();

	            switch (opcion) {
	                // Mostrar los parámetros actuales del juego
	                case 1:
	                    mostrarParametros(document);
	                // Modificar los parámetros del juego
	                case 2:
	                    modificarParametros(document, fileName);
	                // Salir del programa
	                case 3:
	                    salir = true;
	                // Opción no válida
	                default:
	                    System.out.println("Opcion no valida. Intente de nuevo.");
	            }
	        }

	    } catch (ParserConfigurationException | SAXException | IOException e) {
	        // Manejar las excepciones que puedan surgir durante la ejecución del programa
	        e.printStackTrace();
	    }
	}

	// Mostrar los parámetros actuales del juego
	private static void mostrarParametros(Document document) {
	    // Obtener una lista de nodos con el tag "parametros"
	    NodeList nodeList = document.getElementsByTagName("parametros");

	    if (nodeList.getLength() > 0) {
	        // Obtener el primer elemento "parametros"
	        Element parametros = (Element) nodeList.item(0);
            System.out.println("\nPARAMETROS\n");
            System.out.println("Numero de ciudades infectadas al inicio: " + parametros.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent());
            System.out.println("Numero de ciudades infectadas por ronda: " + parametros.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent());
            System.out.println("Numero de enfermedades activas para perder el juego: " + parametros.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent());
            System.out.println("Numero de brotes para perder el juego: " + parametros.getElementsByTagName("numBrotesDerrota").item(0).getTextContent());
        } else {
            System.out.println("No se encontraron parametros en el archivo.");
        }
    }
//modificar los parametros
    private static void modificarParametros(Document document, String fileName) {
        NodeList nodeList = document.getElementsByTagName("parametros");
		Scanner scanner = new Scanner(System.in);
		
        if (nodeList.getLength() > 0) {
            Element parametros = (Element) nodeList.item(0);
            System.out.println("\nMODIFICAR PARAMETROS\n");
            System.out.print("Numero de ciudades infectadas al inicio (actual: " + parametros.getElementsByTagName("numCiudadesInfectadasInicio").item(0).getTextContent() + "): ");
            String numCiudadesInfectadasInicio = scanner.nextLine();
            parametros.getElementsByTagName("numCiudadesInfectadasInicio").item(0).setTextContent(numCiudadesInfectadasInicio);

            System.out.print("Numero de ciudades infectadas por ronda (actual: " + parametros.getElementsByTagName("numCuidadesInfectadasRonda").item(0).getTextContent() + "): ");
            String numCuidadesInfectadasRonda = scanner.nextLine();
            parametros.getElementsByTagName("numCuidadesInfectadasRonda").item(0).setTextContent(numCuidadesInfectadasRonda);

            System.out.print("Numero de enfermedades activas para perder el juego (actual: " + parametros.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).getTextContent() + "): ");
            String numEnfermedadesActivasDerrota = scanner.nextLine();
            parametros.getElementsByTagName("numEnfermedadesActivasDerrota").item(0).setTextContent(numEnfermedadesActivasDerrota);

            System.out.print("Numero de brotes para perder el juego (actual: " + parametros.getElementsByTagName("numBrotesDerrota").item(0).getTextContent() + "): ");
            String numBrotesDerrota = scanner.nextLine();
            parametros.getElementsByTagName("numBrotesDerrota").item(0).setTextContent(numBrotesDerrota);

            guardarCambios(document, fileName);
            System.out.println("\nCambios guardados con exito.");

        } else {
            System.out.println("No se encontraron parametros en el archivo.");
        }
    }
// guardar los cambios
    private static void guardarCambios(Document document, String fileName) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new FileWriter(fileName));

            transformer.transform(source, result);
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}


// Mohamed Oundouh - David Mir 