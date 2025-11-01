package com.example.tp_DataRest;


import enums.Genre;
import model.Centre;
import model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.CentreRepository;
import repository.EtudiantRepository;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.tp_DataRest", "repository"})
@EnableJpaRepositories(basePackages = {"repository"})
@EntityScan(basePackages = {"model"})

public class TpDataRestApplication implements CommandLineRunner {
    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private CentreRepository centreRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpDataRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // 🔹 Création d’un centre
        Centre c1 = Centre.builder()
                .nom_centre("Centre Casablanca")
                .adresse("BdAnfa, Casablanca")
                .build();
        centreRepository.save(c1);
        System.out.println("Centre enregistré avec succès : " + c1);

        // 🔹 Création d’un étudiant lié à ce centre
        Etudiant et1 = Etudiant.builder()
                .nom("Haitam")
                .prenom("Modli")
                .genre(Genre.Homme)
                .centre(c1)
                .build();
        etudiantRepository.save(et1);
        System.out.println("Etudiant enregistré avec succès : " + et1);
    }
}