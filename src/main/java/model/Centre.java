package model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "genre")
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom_centre", nullable = false)
    private String nom_centre;

    @Column(name = "adresse")
    private String adresse;

    @OneToMany(mappedBy = "centre", fetch = FetchType.LAZY)
    private List<Etudiant> etudiants;

}