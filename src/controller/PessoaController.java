package controller;

import pessoa.Pessoa;
import pessoa.PessoaFisica;
import pessoa.PessoaJuridica;
import services.PessoaService;
import utils.io.ScannerSingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaController {
    private static final PessoaService pessoaService = new PessoaService(new ArrayList<>());

    public static PessoaService getPessoaService() {
        return pessoaService;
    }

    public static void cadastrarPessoa() {
        Scanner sc = ScannerSingleton.getScanner();

        System.out.print("Digite o tipo de pessoa (FISICA, JURIDICA): ");
        String tipoPessoa = sc.nextLine().toUpperCase();

        System.out.print("Digite o documento da pessoa: ");
        String documento = sc.nextLine();

        System.out.print("Digite o nome da pessoa: ");
        String nome = sc.nextLine();

        Pessoa novaPessoa;
        if (tipoPessoa.equals("FISICA")) {
            novaPessoa = new PessoaFisica(documento, nome);
        } else if (tipoPessoa.equals("JURIDICA")) {
            novaPessoa = new PessoaJuridica(documento, nome);
        } else {
            System.out.println("Tipo de pessoa inválido. Cadastro cancelado.");
            return;
        }

        pessoaService.cadastrarPessoa(novaPessoa);
    }

    public static void alterarPessoa() {
        Scanner sc = ScannerSingleton.getScanner();

        System.out.print("Digite o documento da pessoa a ser alterada: ");
        String documentoAntigo = sc.nextLine();

        System.out.print("Digite o novo documento da pessoa: ");
        String novoDocumento = sc.nextLine();

        System.out.print("Digite o novo nome da pessoa: ");
        String novoNome = sc.nextLine();

        pessoaService.editarPessoa(documentoAntigo, novoDocumento, novoNome);
    }

    public static List<Pessoa> listarPessoas() {
        return pessoaService.listarPessoas();
    }
}
