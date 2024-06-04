
import java.util.List;
import datos.DepartamentoDAO;
import domain.Departamento;
public class Main {
    public static void DepartamentoMain(String[] args) {

        DepartamentoDAO departamentoDAO = new DepartamentoDAO();

        List <Departamento> departamentos = departamentoDAO.seleccionar();
        for(Departamento d : departamentos){
            System.out.println(d);
        }

    }
}