import PicoPlaca.PicoyPlaca;
import PicoPlaca.Plate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("PREDICTOR DE PICO Y PLACA (Ctrl+C para salir)");
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime fecha;
        Plate placa;
        while (true) {
            try {
                System.out.print("\nIngrese una fecha de circulacion (dd/mm/aaaa) : ");
                String strFecha = scanner.nextLine().trim();
                System.out.print("\nIngrese la hora de circulacion: (HH:MM) : ");
                String hora = scanner.nextLine().trim();
                fecha = LocalDateTime.parse(strFecha + " " + hora, dateFormat);
                fecha.atZone(ZoneId.of("America/Guayaquil"));
            } catch (Exception e) {
                System.err.println("No se puede interpretar fecha u hora, utilice el formato correcto");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("\nIngrese un numero de placa : ");
            String strPlaca = scanner.next().trim();
            try {
                placa = new Plate(strPlaca);
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                continue;
            }
            break;
        }

        PicoyPlaca picoyPlaca = new PicoyPlaca(fecha, placa);
        String formatoDeRespuesta = "El vehiculo con placa: %s, %s puede circular";
        String resultado = (picoyPlaca.isCarAllowed()) ? "SI" : "NO";
        System.out.println(String.format(formatoDeRespuesta, picoyPlaca.getPlate().getNumber(), resultado));
    }
}
