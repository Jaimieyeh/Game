package com.jaimie.game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class GameView extends View {

    private float posX, posY = 400;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("Game", "onDraw:" + getWidth() + "," + getHeight());
        Paint paint = new Paint();
        canvas.drawLine(400,0,0,600,paint);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.santa);
        canvas.drawBitmap(bitmap, posX, posY, paint);
//        for (int i=0; i<getHeight()-bitmap.getHeight(); i+=50){
//            canvas.drawBitmap(bitmap, 400, 300+i, paint);
//        }
    }
    public void moveRight(){
        if (posX < getWidth()-200){
            posX = posX + 50;
            invalidate();
        }
    }

    public void moveLeft(){
        if (posX > 0){
            posX = posX - 50;
            invalidate();
        }
    }

    public void moveUp(){
        if (posY > 50){
            posY = posY - 50;
            invalidate();
        }
    }

    public void moveDown(){
        if (posY < getHeight()-300){
            posY = posY + 50;
            invalidate();
        }
    }

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        if (posX > 0 && posX < getWidth()-130){
            this.posX = posX;
        }

    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }
}
