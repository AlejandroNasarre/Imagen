import java.io.*;

public class TransformaImagen {

    File f = null;

    public TransformaImagen(File fEnt) {

        // Control de existencia del fichero y control de la extensión .bmp (sacar
        if (fEnt.exists() && fEnt.getName().endsWith("bmp"))
            f = fEnt;
            // mensajes de error)
        else
            System.out.println("el fichero no existe o no es bmp");
    }

    public void transformaNegativo() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
        String name = getNombreSinExtension() + "_n.bmp";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Resource/" + name));
        // Transformar a negativo y guardar como *_n.bmp
        byte[] cabecera = bis.readNBytes(54);
        bos.write(cabecera);
        int canal = bis.read();
        while (canal != -1){
            bos.write(255 - canal);
            canal = bis.read();
        }
        bis.close();
        bos.close();
    }

    public void transformaOscuro() throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
        String name = getNombreSinExtension() + "_o.bmp";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Resource/" + name));
        // Transformar a oscuro y guardar como *_o.bmp
        byte[] cabecera = bis.readNBytes(54);
        bos.write(cabecera);
        int canal = bis.read();
        while (canal != -1){
            bos.write(canal/2);
            canal = bis.read();
        }
        bis.close();
        bos.close();
    }


    public void transformaBlancoNegro() throws IOException {

        // Transformar a una imagen en blanco y negro y guardar como *_bn.bmp

    }

    private String getNombreSinExtension() {
        //Devuelve el nombre del archivo f sin extensión
        String name = f.getName();
        int index = 0;
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == '.')
                index = i;
        }
        return name.substring(0, index);
    }
}