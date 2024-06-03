import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Arquivo {

    public void escreverCliente(Cliente cliente) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            os = new FileOutputStream("Clientes.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("++ Cliente ++\n");
            bw.write(cliente.getNomeCliente() + "\n");
            bw.write(cliente.getCpfCliente() + "\n");

        } catch (Exception e) {
            System.out.println("ERRO: " + e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
            }
        }
    }

    public ArrayList<Cliente> lerClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        String linhaLer;

        try {
            is = new FileInputStream("Clientes.txt");
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            linhaLer = br.readLine();

            while (linhaLer != null) {
                if (linhaLer.contains("++ Cliente ++")) {
                    Cliente cliente = new Cliente();
                    cliente.setNomeCliente(br.readLine());
                    cliente.setCpfCliente(br.readLine());

                    clientes.add(cliente);
                }
                linhaLer = br.readLine();
            }
        } catch (Exception e) {
        } finally {
            try {
                br.close();
            } catch (Exception e) {
            }
        }

        return clientes;
    }

    public void ordenarClientesAZ(ArrayList<Cliente> clientes) {
        Collections.sort(clientes, Comparator.comparing(Cliente::getNomeCliente));
    }

    public void ordenarClientesZA(ArrayList<Cliente> clientes) {
        Collections.sort(clientes, (c1, c2) -> c2.getNomeCliente().compareTo(c1.getNomeCliente()));
    }
}