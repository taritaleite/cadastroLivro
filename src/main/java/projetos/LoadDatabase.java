//package projetos;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import projetos.entidade.Categoria;
//import projetos.entidade.Livro;
//import projetos.repositorio.LivroRepositorio;
//
//@Configuration
//public class LoadDatabase {
//
//    @Bean
//    CommandLineRunner initDatabase(LivroRepositorio repositorio) {
//        return args -> {
//            // Inserção de livros de tecnologia em português
//            repositorio.save(new Livro(null, "Código Limpo: Habilidades Práticas do Agile Software", "1ª", "978-0132350884", Categoria.TECNOLOGIA));
//            repositorio.save(new Livro(null, "Dominando Algoritmos com C", "2ª", "978-8550804606", Categoria.TECNOLOGIA));
//
//            // Inserção de livros de medicina em português
//            repositorio.save(new Livro(null, "Anatomia Humana Básica", "2ª", "978-8527733112", Categoria.MEDICINA));
//            repositorio.save(new Livro(null, "Patologia Básica", "10ª", "978-8535281648", Categoria.MEDICINA));
//
//            // Inserção de livros de direito em português
//            repositorio.save(new Livro(null, "Vade Mecum Saraiva – OAB e Concursos", "14ª", "978-6555592368", Categoria.DIREITO));
//            repositorio.save(new Livro(null, "Direito Constitucional Descomplicado", "18ª", "978-8530983385", Categoria.DIREITO));
//        };
//    }
//}
//
