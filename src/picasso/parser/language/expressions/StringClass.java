package picasso.parser.language.expressions;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import picasso.model.Pixmap;
import picasso.parser.language.ExpressionTreeNode;

public class StringClass extends ExpressionTreeNode {
    private String file_name;
    private Pixmap pixmap;
    private Dimension dim;

    public StringClass(String file_name) {
        this.file_name = "/Users/janeetbajracharya/Desktop/Code/2023F/CSCI209/hw/picasso-codecatalysts/images/AmoebaMorris.png";
        pixmap = new Pixmap();
        pixmap.read(this.file_name);
        dim = this.pixmap.getSize();
    }

    @Override
    public RGBColor evaluate(double x, double y) {
        return new RGBColor(pixmap.getColor(domainToImage(x, dim.getWidth()), domainToImage(y, dim.getHeight())));
    }

    private int domainToImage(double x, double size) {
        return (int) (((x + 1) / 2) * size);
    }

}
