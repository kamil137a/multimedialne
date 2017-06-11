/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jnativehookexample;

import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

/**
 *
 * @author x
 */
public class MouseWheelListener implements NativeMouseWheelListener {

    @Override
    public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
        System.out.println("Mosue Wheel Moved: " + e.getWheelRotation());
    }
}
