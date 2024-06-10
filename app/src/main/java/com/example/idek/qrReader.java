package com.example.idek;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.qrcode.QRCodeReader;

import java.util.HashMap;

public class qrReader {

    public String decoded(BinaryBitmap plaatje, HashMap<DecodeHintType,?> hashmap) throws NotFoundException, FormatException, ChecksumException {

        QRCodeReader qr = new QRCodeReader(); // (*・ω・)ﾉ QRCodeReader
        String qrResultDing; //alvast een string aanmaken waarin later de gedecodeerde zooi in gestopt wordt

        try{
            Result resDing = qr.decode(plaatje, hashmap); //wauw. zonder medicatie is mijn beste uitleg hiervoor: "magic happens (/￣ー￣)/~~☆’.･.･:★’.･.･:☆"
            //aight op basis van wat je allemaal kan vragen van Result, slaat hij de ingelezen qr code in zijn geheel op.
            //je zou specifieke shit kunnen opvragen afhankelijk van welke type barcode je hebt ingescand, bijv de "result points" (waarvan ik gok dat het in een qr code de grote blokken kunnen zijn?)
            //en bytes en bits van wat er geencodeerd is in een qr code/aztec ding/barcode

            qrResultDing = resDing.getText(); //geeft de string wat in de qr code stond terug en stopt dat in de string wat eerder is aangemaakt.

            return qrResultDing;

        } catch (NotFoundException nf){
            //aaaaaaaah oke wat doe ik met de rest
            nf.printStackTrace();
        } catch(FormatException fx){
            fx.printStackTrace();
        } catch (ChecksumException e){
            e.printStackTrace();
        }
        return null;
    }
}
