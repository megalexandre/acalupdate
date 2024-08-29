package br.org.acal.infra.backup;

public class DatabaseFunctions {
    /*
    public void createbackup(String path){

        PrintWriter pw = null;
        Scanner sc = null;
        try {

            File caminho = new File("sql/");
            if (!caminho.exists()) {
                caminho.mkdir();
            }
            Calendar c = Calendar.getInstance();
            String[] s = SimpleDateFormat.getDateInstance(SimpleDateFormat.SHORT).format(c.getTime()).split("/");
            String data = "";

            for (String temp : s) {
                data = data.concat(temp);
            }

            String acal = "acal" + data + ".sql";
            String[] comando = {"cmd.exe", "/c", "mysqldump -u root -p123 acal > sql/" + acal};

            Process p;
            try {
                p = Runtime.getRuntime().exec(comando);
                if (p.waitFor() == 0) {
                    System.out.println("mysqldump executado");
                } else {
                    System.out.println("erro no mysqldump");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }


            File file = new File("sql/" + acal);
            JFileChooser jf = new JFileChooser();
            int result = jf.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {

                File f = new File(jf.getSelectedFile().getAbsolutePath() + ".sql");
                f.createNewFile();
                pw = new PrintWriter(f);
                sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String s1 = sc.nextLine();
                    pw.println(s1);
                }

                JOptionPane.showMessageDialog(null, "Backup gerado com sucesso!", "Backup", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar o Backup, contate o suporte");
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        finally {
            if (pw != null) {

                pw.close();
            }
            if (sc != null) {

                sc.close();
            }
        }
    }
     */
}
