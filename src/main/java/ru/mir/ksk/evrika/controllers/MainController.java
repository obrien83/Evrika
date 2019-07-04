package ru.mir.ksk.evrika.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.RoundingMode;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Controller
public class MainController {

    // Обработка данных и получение представления
    @GetMapping({"/", "/info"})
    public String info(Model model) {
        Runtime runtime = Runtime.getRuntime();
        model.addAttribute("time", getCurrentDate());
        model.addAttribute("name", getThisComputerName());
        model.addAttribute("freeJavaMemory", (getFreeJavaMemory(runtime)));
        model.addAttribute("totalJavaMemory", (getTotalJavaMemory(runtime)));
        return "info";
    }

    // Получение текущей даты компьютера
    private String getCurrentDate() {
        return LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
    }

    // Получение имени компьютера
    private String getThisComputerName() {
        try {
            return java.net.InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return "Неизвестный хост, получение имени компьютера невозможно";
        }
    }

    // Получение свободной памяти Java в мегабайтах
    private String getFreeJavaMemory(Runtime runtime) {
        return getFormattedDoubles((double)(runtime.freeMemory()) / (double)(1024 * 1024));
    }

    // Получение общей памяти Java в мегабайтах
    private String getTotalJavaMemory(Runtime runtime) {
        return getFormattedDoubles((double)(runtime.totalMemory()) / (double) (1024 * 1024));
    }

    // Форматирование и округление дробных чисел
    private String getFormattedDoubles(double number) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(number);
    }
}
