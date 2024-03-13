import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


public class Main
{
    public static void main(String[] args) {
        LocalDateTime data = LocalDateTime.now();
        LocalDateTime dataLogoAposAluguel = data.plusMinutes(15);
        LocalDateTime dataTresDiasAntes = data.minusDays(3);
        LocalDateTime dataDoisDiasAntes = dataTresDiasAntes.plusMinutes(1);
        long tresDias = Duration.between(dataTresDiasAntes, data).toDays() + 1;
        long doisDias = Duration.between(dataDoisDiasAntes, data).toDays() + 1;
        long nenhumDia = Duration.between(dataLogoAposAluguel, data).toDays() + 1;
        System.out.println(data);
        System.out.println(dataLogoAposAluguel);
        System.out.println(dataTresDiasAntes);
        System.out.println(dataDoisDiasAntes);
        System.out.println(nenhumDia);
        System.out.println(tresDias);
        System.out.println(doisDias);
    }
}