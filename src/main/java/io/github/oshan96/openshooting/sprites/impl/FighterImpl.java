package io.github.oshan96.openshooting.sprites.impl;

import io.github.oshan96.openshooting.sprites.BasicObject;
import io.github.oshan96.openshooting.sprites.Fighter;

import java.awt.image.BufferedImage;

/**
 * @author oshan
 */
public abstract class FighterImpl extends BasicObject implements Fighter {
    /**
     * attackSpeed determines the time delay between two hits
     */
    protected double attackSpeed;

    public FighterImpl(double x, double y, double height, double width) {
        super(x, y, height, width);

    }

    public FighterImpl(double x, double y, double height, double width, BufferedImage image, double attackSpeed) {
        this(x, y, height, width);
        this.attackSpeed = attackSpeed;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
