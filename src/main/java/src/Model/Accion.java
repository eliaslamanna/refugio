package src.Model;

public enum Accion {

    PARASITOS{
        public String toString(){
            return "Control de Parasitos";
        }
    },
    ANTIPARASITARIO{
        public String toString(){
            return "Colocar Antiparasitario";
        }
    },

    PESO{
        public String toString(){
            return "Control de Peso";
        }
    },

    TAMAÑO{
        public String toString(){
            return "Control de Tamaño";
        }
    },

    NUTRICION{
        public String toString(){
            return "Chequeo de Nutricion";
        }
    },

    VACUNAR {
        public String toString(){
            return "Aplicar vacuna";
        }
    },

    }