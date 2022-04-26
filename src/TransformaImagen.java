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
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/" + name));
        // Transformar a negativo y guardar como *_n.bmp
        byte[] cuerpo = bis.readAllBytes();
        int[] cuerpoAux = new int[cuerpo.length];
        for (int i = 53; i < cuerpoAux.length; i++) {
            cuerpoAux[i] = cuerpo[i];
            cuerpoAux[i] = 255 - cuerpo[i];
        }
        for (int i = 0; i < cuerpoAux.length; i++) {
            cuerpo[i] = (byte) cuerpoAux[i];
        }
        bos.write(cuerpo);
    }

    public void transformaOscuro() throws IOException {

        // Transformar a una imagen más oscura y guardar como *_o.bmp


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