
/*
  Titre      : Communication Serie avec Java en utilisant la librairie JSSC
  Auteur     : Ernest Samuel Andre
  Date       : 16/10/2023
  Description: Le programme permet ainsi d'établir une communication série avec un dispositif connecté sur le port COM3,
               d'envoyer des données à ce dispositif, d'attendre une réponse, de lire la réponse et enfin de fermer le port série. 
               Il s'agit d'un exemple simple d'utilisation de JSSC pour la communication série en Java.
  Version    : 0.0.1
  Source du Code    : https://code.google.com/archive/p/java-simple-serial-connector/wikis/jSSC_examples.wiki
  Source des librairies jar : https://github.com/java-native/jssc/releases
*/
// Importation des librairies
import jssc.SerialPort;
import jssc.SerialPortException;

public class SerialCom {
    public static void main(String[] args) {
        // Specification du port a utliser
        String serialPortName = "COM3";
        SerialPort serialPort = new SerialPort(serialPortName);

        try {
            // Ouvrir le port série
            serialPort.openPort();

            // Configurer les paramètres de communication (vitesse, bits de données, bits de
            // stop, etc.)
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            // Envoyer des données au dispositif
            String dataToSend = "Hello Internet des Objets";
            serialPort.writeString(dataToSend);

            // Attendre un certain temps pour la réponse (ajustez selon les besoins)
            Thread.sleep(1000);

            // Lire la réponse du dispositif
            String response = serialPort.readString();
            System.out.println("Réponse du dispositif : " + response);

            // Fermer le port série
            serialPort.closePort();
        } catch (SerialPortException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
