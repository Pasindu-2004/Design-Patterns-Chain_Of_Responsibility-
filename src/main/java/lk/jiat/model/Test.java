package lk.jiat.model;

class Patient{
    private String name;
    private String symptom;

    public Patient(String name, String symptom) {
        this.name = name;
        this.symptom = symptom;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return symptom;
    }

}

abstract class Doctor{
    private Doctor doctor;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public abstract void handle(Patient patient);
}

class GeneralDoctor extends Doctor{


    public void handle(Patient patient){
        if (patient.getSymptom().equalsIgnoreCase("Fever")){
            System.out.println("General Doctor Treating "+patient.getName());
        }else {
            this.getDoctor().handle(patient);
        }
    }
}

class Specialist extends Doctor{

    public void handle(Patient patient){
        if (patient.getSymptom().equalsIgnoreCase("Chest Pain")){
            System.out.println("Specialist is Treating "+patient.getName());
        }else {
            this.getDoctor().handle(patient);
        }
    }
}

class Consultant extends Doctor{

    public void handle(Patient patient){
        if (patient.getSymptom().equalsIgnoreCase("Heart Problem")){
            System.out.println("Consultant is Treating "+patient.getName());
        }else {
            System.out.println("Can't handle....");
        }
    }

}

public class Test {
    public static void main(String[] args) {
        Patient patient = new Patient("Saman","Fever");

        GeneralDoctor generalDoctor = new GeneralDoctor();
        Specialist specialist = new Specialist();
        Consultant consultant = new Consultant();

        generalDoctor.setDoctor(specialist);
        specialist.setDoctor(consultant);

        generalDoctor.handle(patient);
    }
}
