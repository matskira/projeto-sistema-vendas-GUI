package br.com.foursys.vendas.util;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.ie.IESaoPauloValidator;
import br.com.foursys.vendas.model.Estoque;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class Valida {

    public static boolean vazio(String aux) {
        aux = aux.replace(".", " ");
        aux = aux.replace("-", " ");
        aux = aux.replace("/", " ");
        aux = aux.replace("(", " ");
        aux = aux.replace(")", " ");
        if (aux.trim().equals("")) {
            return true;
        }
        return false;
    }

    public static boolean testaZero(int aux) {
        return aux == 0;
    }

    public static boolean cpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
        } catch (Exception e) {
            return false;
        }
        if (cpf.equals(Mensagem.cpfZero)) {
            return false;
        }
        return true;
    }

    public static boolean rg(String rg) {
        if (rg.equals(Mensagem.rgZero)) {
            return false;
        }
        return true;
    }

    private static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static boolean dataValida(String data2) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        String dataString = data2;

        String dataSeparada[] = dataString.split("/");
        String dataInvertida = "";

        dataInvertida += dataSeparada[2];
        dataInvertida += dataSeparada[1];
        dataInvertida += dataSeparada[0];

        try {
            Date data = sdf.parse(dataString);
            return Integer.parseInt(dataInvertida.trim().replace("/", "")) >= Integer.parseInt(getDateTime().trim().replace("/", ""));
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static boolean data(String data2) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        String dataString = data2;

        String dataSeparada[] = dataString.split("/");
        String dataInvertida = "";

        dataInvertida += dataSeparada[2];
        dataInvertida += dataSeparada[1];
        dataInvertida += dataSeparada[0];

        try {
            Date data = sdf.parse(dataString);

            return Integer.parseInt(dataInvertida.trim().replace("/", "")) <= Integer.parseInt(getDateTime().trim().replace("/", ""));
            // se passou pra cá, é porque a data é válida
        } catch (ParseException e) {
            // se cair aqui, a data é inválida
            return false;
        }

    }

    public static boolean email(String email) {
        if (email != null && email.length() > 0) {
            String expression = Mensagem.validaEmail;
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean cnpj(String cnpj) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        try {
            cnpjValidator.assertValid(cnpj);
        } catch (Exception e) {
            return false;
        }
        if (cnpj.equals(Mensagem.cnpjZero)) {
            return false;
        }
        return true;
    }

    public static boolean ie(String ie) {
        IESaoPauloValidator ieSaoPauloValidator = new IESaoPauloValidator();
        try {
            ieSaoPauloValidator.assertValid(ie);
        } catch (Exception e) {
            return false;
        }
        if (ie.equals(Mensagem.ieZero)) {
            return false;
        }
        return true;
    }

    public static boolean valor(String valor) {
        try {
            double aux = Double.parseDouble(valor);
        } catch (NumberFormatException E) {
            return false;
        }
        return true;
    }

    public static boolean numero(String numero) {
        try {
            int aux = Integer.parseInt(numero);
        } catch (NumberFormatException E) {
            return false;
        }
        return true;
    }

    public static boolean estoque(int quantidadeDigitada, Estoque estoque) {
        int aux = estoque.getQuantidadeEstoque() - quantidadeDigitada;
        if (quantidadeDigitada > estoque.getQuantidadeEstoque() || aux < estoque.getQuantidadeMinima()) {
            return false;
        }
        return true;
    }

    public static boolean espacos(String aux) {
        return aux.trim().length() != aux.length(); // Retorna TRUE se tiver espaços
    }

    public static boolean xMaiorQueY(double x, double y) {
        return x > y;
    }

    public static boolean negativo(int aux) {
        return aux < 0; // Se número menor que zero retorna positivo
    }

    public static boolean nome(String nome) {
        return nome.matches(Mensagem.validaNome);
    }
}
