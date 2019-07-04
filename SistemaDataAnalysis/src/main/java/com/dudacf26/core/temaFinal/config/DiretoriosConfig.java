package com.dudacf26.core.temaFinal.config;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DiretoriosConfig {

    public static final Path ENTRADA = Paths.get(System.getProperty("user.home") + "/data//in/");
    public static final Path SAIDA = Paths.get(System.getProperty("user.home") + "/data/out/");

    public static final String EXTENSAO_DAT = ".dat";
    public static final String EXTENSAO_DONE_DAT = ".done.dat";}
