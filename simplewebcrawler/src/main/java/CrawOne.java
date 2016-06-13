import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawOne {

    public static void main(String... args) throws Exception {

        StringBuilder json = new StringBuilder();
        json.append("{\n");

//        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/forma-fisica-corpo-perfeito-e-consumismo.htm").get();
//        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/impeachment-a-presidente-deve-perder-o-mandato.htm").get();
//        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/carta-convite-discutir-discriminacao-na-escola.htm").get();
//        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/a-tecnologia-e-a-eliminacao-de-empregos.htm").get();
//        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/por-que-o-brasil-nao-consegue-vencer-o-aedes-aegypti.htm").get();
//        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/mariana-fatalidade-ou-negligencia.htm").get();
//        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/bandido-bom-e-bandido-morto.htm").get();
//        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/o-sucesso-vem-da-escola-ou-do-esforco-individual.htm").get();
        Document doc = Jsoup.connect("http://educacao.uol.com.br/bancoderedacoes/propostas/disciplina-ordem-e-autoridade-favorecem-a-educacao.htm").get();


        Elements h1 = doc.select("h1");
        String tema = h1.get(2).text();

        Elements spanData = doc.select("time");
        String data = spanData.attr("datetime");

        Elements divs = doc.select("div[id]");
        for (Element div : divs) {
            if (div.attr("id").contains("texto")) {

                String subject = div.getElementsByTag("p").get(2).text();
                json.append("  'tema': " + "'" + tema + "',\n");
                json.append("  'data': " + "'" + data + "',\n");
                json.append("  'contexto': " + "'" + subject + "',\n");
                json.append("  'redacoes': " + "[\n");

                for (Element tr : div.getElementsByTag("tr")) {
                    Elements tds = tr.getElementsByTag("td");
                    if (tds.size() > 0) {
                        String url = tds.get(0).getElementsByTag("a").get(0).attr("href");
                        String title = tds.get(0).getElementsByTag("a").get(0).text();
                        String score = tds.get(1).text();
                        score = score.replaceAll(",", ".");

                        json.append("  {\n");
                        json.append("    'titulo': " + "'" + title + "',\n");
                        json.append("    'nota': " + "" + score + ",\n");

                        Document docInt = Jsoup.connect(url).get();
                        Elements divsInt = docInt.select("div[id]");
                        for (Element divInt : divsInt) {
                            if (divInt.attr("id").contains("texto")) {
                                String texto = "";
                                String analise = "";
                                for (Element child : divInt.children()) {
                                    if (child.tagName().equals("p")) {
                                        texto = texto + child.outerHtml();
                                    }
                                    if (child.tagName().equals("section")) {
                                        Elements ps = child.getElementsByTag("p");
                                        analise = ps.get(0).text();
                                    }
                                }

                                String textoPuro = texto.replaceAll("<u>", "");
                                textoPuro = textoPuro.replaceAll("<\\/u>", "");
                                textoPuro = textoPuro.replaceAll("<span class=\"certo\">[^>]*>", "");
                                textoPuro = textoPuro.replaceAll("<span class=\"erro\">", "");
                                textoPuro = textoPuro.replaceAll("<\\/span>", "");
                                textoPuro = textoPuro.replaceAll("<p>", "");
                                textoPuro = textoPuro.replaceAll("<\\/p>", "<BR>");
//                                textoPuro = textoPuro.replaceAll("<br>", "\n");

                                json.append("    'texto': " + "'" + textoPuro + "',\n");
                                json.append("    'texto_corrigido': " + "'" + texto + "',\n");
                                json.append("    'analise': " + "'" + analise + "'\n");
                            }
                        }
                        json.append("  },\n");

                    }
                }
                json.append("]\n");
            }

        }
        json.append("}\n");

        System.out.println(json);
    }
}
