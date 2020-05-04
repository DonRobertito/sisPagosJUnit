package edd.junit.syspagos;

import edd.junit.syspagos.excepciones.CargoException;
import edd.junit.syspagos.excepciones.MesesTrabajoException;
import edd.junit.syspagos.excepciones.NombreEmpleadoException;
import edd.junit.syspagos.excepciones.NumeroEmpleadoException;
import org.junit.jupiter.api.*;


@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class EmpleadoTest {


    Empleado e = new Empleado();

    @BeforeEach
    public void before() {

        Empleado e = new Empleado();

    }


    @Test @DisplayName("Establecer numero empleado rango valido")
    public void establecerNumero_empleado_Correcto() {

        try {
            e.establecerNumero_empleado("4");
        } catch (NumeroEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(4,e.getNumero_empleado());

    }

    @Test @DisplayName("Establecer numero empleado limite 000")
    public void establecerNumero_empleado_000() {

        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("0");
        });

    }

    @Test @DisplayName("Establecer numero empleado limite 1000")
    public void establecerNumero_empleado_1000() {

        Exception exception = Assertions.assertThrows(NumeroEmpleadoException.class, () -> {
            e.establecerNumero_empleado("0");
        });

    }

    @Test @DisplayName("Establecer numero empleado 001")
    public void establecerNumero_empleado_001() {

        try {
            e.establecerNumero_empleado("001");
        } catch (NumeroEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(001,e.getNumero_empleado());

    }

    @Test @DisplayName("Establecer empleado n = 999")
    public void establecerNumero_empleado_999() {

        try {
            e.establecerNumero_empleado("999");
        } catch (NumeroEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(999,e.getNumero_empleado());
    }


    @Test @DisplayName("Establecer nombre correcto")
    public void estableceNombre_empleado_correcto() {

        try {
            e.estableceNombre_empleado("MartaBravo");
        } catch (NombreEmpleadoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals("MartaBravo", e.getNombre_empleado());

    }

    @Test @DisplayName("Establecer nombre incorrecto, longitud menor a 10")
    public void establecerNombre_empleado_incorrecto() {

        Exception exception = Assertions.assertThrows(NombreEmpleadoException.class, () -> {
            e.estableceNombre_empleado("Ruben");
        });

    }

    @Test @DisplayName("Establecer nombre incorrecto, longitud mayor a 10")
    public void establecerNombre_empleado_incorrecto_2() {

        Exception exception = Assertions.assertThrows(NombreEmpleadoException.class, () -> {
            e.estableceNombre_empleado("RobertoFreire");
        });

    }



    @Test @DisplayName("Establecer meses de trabajo valido")
    public void establecerMeses_trabajo_correcto() {

        try {
            e.estableceMeses_Trabajo("17");
        } catch (MesesTrabajoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(17,e.getMeses_trabajo());

    }

    @Test @DisplayName("Establecer meses trabajados limite -1")
    public void establecerMeses_trabajo_001() {

        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () -> {
            e.estableceMeses_Trabajo("-1");
        });

    }

    @Test @DisplayName("Establecer meses trabajo limite 1000")
    public void establecerMeses_trabajo_1000() {

        Exception exception = Assertions.assertThrows(MesesTrabajoException.class, () -> {
            e.estableceMeses_Trabajo("1000");
        });

    }

    @Test @DisplayName("Establecer meses trabajo limite 000")
    public void establecerMeses_trabajo_000() {

        try {
            e.estableceMeses_Trabajo("000");
        } catch (MesesTrabajoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(000,e.getMeses_trabajo());

    }

    @Test @DisplayName("Establecer meses trabajo en limite 999")
    public void establecerMeses_Trabajo_999() {

        try {
            e.estableceMeses_Trabajo("999");
        } catch (MesesTrabajoException ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(999,e.getMeses_trabajo());

    }

    @Test @DisplayName("Establecer Cargo de directivo")
    public void establecerDirectivo() {

        try {
            e.establecerSerDirectivo("+");
        } catch (CargoException ex) {
            Assertions.fail();
        }
        Assertions.assertTrue(e.getDirectivo());

    }

    @Test @DisplayName("Establecer Cargo de no-directivo")
    public void establecer_No_Directivo() {

        try {
            e.establecerSerDirectivo("-");
        } catch (CargoException ex) {
            Assertions.fail();
        }
        Assertions.assertFalse(e.getDirectivo());

    }

    @Test @DisplayName("Establecer cargo directivo de forma incorrecta")
    public void establecerCargo_No_Valido() {

        Exception exception = Assertions.assertThrows(CargoException.class, () -> {
            e.establecerSerDirectivo("directivo");
        });

    }

    @Test @DisplayName("Calcular prima P1")
    public void establecerPrima_P1() {

        try {
            e.calcularPrima("732", "Ruben12345", "12", "+");
        } catch (Exception ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P1, e.prima);

    }

    @Test @DisplayName("Calcular prima P2")
    public void establecerPrima_P2() {

        try {
            e.calcularPrima("732", "12345RoBeR", "12", "-");
        } catch (Exception ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P2, e.prima);

    }
    @Test @DisplayName("Calcular prima P3")
    public void establecerPrima_P3() {

        try {
            e.calcularPrima("732", "Ruben12345", "8", "+");
        } catch (Exception ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P3, e.prima);

    }

    @Test @DisplayName("Calcular prima P4")
    public void establecerPrima_P4() {

        try {
            e.calcularPrima("732", "Ruben12345", "10", "-");
        } catch (Exception ex) {
            Assertions.fail();
        }
        Assertions.assertEquals(Prima.P4, e.prima);

    }


}