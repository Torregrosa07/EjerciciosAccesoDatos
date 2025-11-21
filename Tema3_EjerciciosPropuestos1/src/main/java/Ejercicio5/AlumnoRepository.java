package Ejercicio5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class AlumnoRepository {
    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("alumnosPU");

    public void insertar (Alumno alumno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        em.close();
    }

    public List<Alumno> listar() {
        EntityManager em = emf.createEntityManager();
        List<Alumno> alumnos = em.createQuery("from Alumno", Alumno.class).getResultList();
        em.close();
        return alumnos;
    }
}

