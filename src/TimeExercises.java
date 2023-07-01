import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class TimeExercises {

    public static void main(String[] args){

        /*
        Period periodOfDays = Period.ofDays(10);
        System.out.println(periodOfDays);
        Duration durationOfDays = Duration.ofDays(10);
        System.out.println(durationOfDays);
        LocalDateTime dateTime = LocalDateTime.of(1990, 01, 01, 10, 10, 10);
        dateTime =dateTime.plus(durationOfDays);
        System.out.println(dateTime);
        var instant = Instant.now();
        System.out.println(instant);
        instant = Instant.ofEpochSecond(0);
        System.out.println(instant);
        instant = Instant.ofEpochSecond(2_000_000);
        System.out.println(instant);
        */

        /*
        var zi = ZoneId.of("America/New_York");
        var f1 = LocalDate.of(2020,11,30);
        var h1 = LocalTime.of(15,20,30);
        var zdt1 = ZonedDateTime.of(f1,h1,zi);
        var i3 = zdt1.toInstant();
        System.out.println(zdt1);
        System.out.println(i3);
        */
        /*
        2020-11-30T15:20:30-05:00[America/New_York]
        2020-11-30T20:20:30Z
        */

        /*
        var d1 = Duration.ofDays(2);
        System.out.println(d1);
        var d2 = Duration.ofSeconds(150);
        System.out.println(d2);
        var d3 = Duration.ofMinutes(150);
        System.out.println(d3);
        var d4 = d1.plus(d2).plus(d3);
        System.out.println(d4);
        */
        /*
        PT48H
        PT2M30S
        PT2H30M
        PT50H32M30S
        */
    
        /*
        var ldt1 = LocalDateTime.of(2020,11,20,22,30,15);// 21 HORAS DEL DIA 20
        var ldt2 = LocalDateTime.of(2020,11,21,1,30,15);// 6 HORAS DEL DIA 21
        var zdt1 = ZonedDateTime.of(ldt1, ZoneId.of("Europe/Amsterdam"));// +01:00
        System.out.println(zdt1);
        var zdt2 = ZonedDateTime.of(ldt2, ZoneId.of("America/New_York"));// -05:00
        System.out.println(zdt2);
        System.out.println(Duration.between(zdt1,zdt2));
        */
        /*
        2020-11-20T22:30:15+01:00[Europe/Amsterdam]
        2020-11-21T01:30:15-05:00[America/New_York]
        PT9H
        */


        /*
        var i1 = Instant.now();
        System.out.println(i1);
        var i2 = i1.plus(2, ChronoUnit.HOURS);
        System.out.println(i2);
        ZonedDateTime z1 = i1.atZone(ZoneId.of("America/New_York"));
        System.out.println(z1);
        ZonedDateTime z2 = i2.atZone(ZoneId.of("Europe/Madrid"));
        System.out.println(z2);
        System.out.println(Duration.between(z1, z2));

        //2023-03-18T18:44:23.557813Z
        //2023-03-18T20:44:23.557813Z
        //2023-03-18T14:44:23.557813-04:00[America/New_York]
        //2023-03-18T21:44:23.557813+01:00[Europe/Madrid]
        //PT2H
        */

        /*
        //Cambio de zona a estados unidos cuando se presenta cambio de horario el 13 de marzo a las 02:30. A pesar del cambio de horario no se afecta la hora porque se suman dias con plusDay
        LocalDateTime ld1 = LocalDateTime.of(2022,3,13,1,30,30);
        System.out.println(ld1);
        ZonedDateTime zd1 = ZonedDateTime.of(ld1,ZoneId.of("America/New_York"));
        System.out.println(zd1);
        ZonedDateTime zd2 = zd1.plusDays(1);
        System.out.println(zd2);
        System.out.println(zd2.toLocalDateTime());

        //2022-03-13T01:30:30
        //2022-03-13T01:30:30-05:00[America/New_York]
        //2022-03-14T01:30:30-04:00[America/New_York]
        //2022-03-14T01:30:30
         */


        /*
        //Cambio de zona a estados unidos cuando se presenta cambio de horario el 13 de marzo a las 02:30. Debido al cambio de horario se afecta la hora porque se suman horas con plusHours
        LocalDateTime ld1 = LocalDateTime.of(2022,3,13,1,30,30);
        System.out.println(ld1);
        ZonedDateTime zd1 = ZonedDateTime.of(ld1,ZoneId.of("America/New_York"));
        System.out.println(zd1);
        ZonedDateTime zd2 = zd1.plusHours(1);
        System.out.println(zd2);
        System.out.println(zd2.toLocalDateTime());

        //2022-03-13T01:30:30
        //2022-03-13T01:30:30-05:00[America/New_York]
        //2022-03-13T03:30:30-04:00[America/New_York]
        //2022-03-13T03:30:30
         */

        LocalDateTime localDateTime = LocalDateTime.of(2001,Month.FEBRUARY,5,10,00,30);
        Duration duration = Duration.ofDays(60).minusDays(5).ofHours(3).plusMinutes(30);
        localDateTime.minus(duration);
        System.out.println(localDateTime);


    }
}


