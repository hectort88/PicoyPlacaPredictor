package PicoPlaca;

import java.time.DayOfWeek;

public class Plate {
    private String number;

    public Plate(String number) {
        this.setPlate(number);
    }

    public String getNumber() {
        return number;
    }

    public void setPlate(String plateNumber) throws IllegalArgumentException {
        String plateNumberFormated = plateNumber.toUpperCase().replaceAll("\\s+","");
        if (!Character.isDigit(plateNumberFormated.charAt(plateNumberFormated.length() - 1))) {
            throw new IllegalArgumentException("El ultimo caracter de la placa debe ser un numero");
        }
        if (plateNumberFormated.length() > 8) {
            throw new IllegalArgumentException("La placa no debe contener mas de 7 caracteres");
        }
        this.number = plateNumberFormated;
    }

    public DayOfWeek getRestrictedDay() {
        char lastChar = number.charAt(number.length() - 1);
        switch (lastChar) {
            case '1':
            case '2':
                return DayOfWeek.MONDAY;
            case '3':
            case '4':
                return DayOfWeek.TUESDAY;
            case '5':
            case '6':
                return DayOfWeek.WEDNESDAY;
            case '7':
            case '8':
                return DayOfWeek.THURSDAY;
            case '9':
            case '0':
                return DayOfWeek.FRIDAY;
            default:
                throw new IllegalArgumentException("El ultimo caracter debe ser numerico");
        }
    }
}
