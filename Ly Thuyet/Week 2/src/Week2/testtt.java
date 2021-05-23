package Week2;

public class testtt {
	static class PhanSo{

        private int tu,mau;
        public PhanSo()
        {
            this.tu = 0 ;
            this.mau = 0;
        }
        public PhanSo(int tu, int mau)
        {
            super();
            this.tu = tu;
            this.mau = mau;
        }
        public int getTu()
        {
            return tu;
        }
    
        public void setTu(int tu)
        {
            this.tu= tu;
        }

        public int getMau(){
            return mau;
        }
        
        public void setMau(int mau)
        {
            this.mau = mau;
        }

        public void nhapPhanSo()
        {
            Scanner input= new Scanner(System.in);
            System.out.println("Nhap tu: ");
            int tu = input.nextInt();
            System.out.println("Nhap mau: ");
            int mau = input.nextInt();

            this.tu = tu;
            this.mau = mau;
            
        }

        public void xuatPhanSo()
        {
            System.out.println(this.tu + "/" + this.mau);
        }
        public int gcd(int a, int b)
        {
            while(a!=b)
            {
                if(a>b)
                {
                    a-=b;
                }
                else{
                    b-=a;
                }
            }
            return a;
        }
        public void rutGonPhanSo()
        {
            int gcd = gcd(this.getTu(), this.getMau());
            this.setTu(this.getTu()/gcd);
            this.setMau(this.getMau()/gcd);
        }
        public void cong_2_PhanSo(PhanSo a )
        {
            int newTu = this.getTu() * a.getMau() + a.getTu()*this.getMau();
            int newMau = this.getMau()*a.getMau();
            PhanSo newPhanSo = new PhanSo(newTu,newMau);
            newPhanSo.rutGonPhanSo();
            System.out.println("Tong 2 phan so: " + newPhanSo.getTu() + "/" + newPhanSo.getMau() );
        }
        public void tru_2_PhanSo(PhanSo a )
        {
            int newTu = this.getTu() * a.getMau() - a.getTu()*this.getMau();
            int newMau = this.getMau()*a.getMau();
            PhanSo newPhanSo = new PhanSo(newTu,newMau);
            newPhanSo.rutGonPhanSo();
            System.out.println("Hieu 2 phan so: " + newPhanSo.getTu() + "/" + newPhanSo.getMau() );
        }
        
        public void nhan_2_PhanSo(PhanSo a )
        {
            int newTu = this.getTu()*a.getTu();
            int newMau = this.getMau()*a.getMau();
            PhanSo newPhanSo = new PhanSo(newTu,newMau);
            newPhanSo.rutGonPhanSo();
            System.out.println("Tich 2 phan so: " + newPhanSo.getTu() + "/" + newPhanSo.getMau() );
        }

        public void chia_2_PhanSo(PhanSo a )
        {
            int newTu = this.getTu() * a.getMau();
            int newMau = this.getMau()*a.getTu();
            PhanSo newPhanSo = new PhanSo(newTu,newMau);
            newPhanSo.rutGonPhanSo();
            System.out.println("Tong 2 phan so: " + newPhanSo.getTu() + "/" + newPhanSo.getMau() );
        }
        
        
    }
    
    static class FractionArray extends PhanSo{
        private PhanSo []array ; 
        public FractionArray()
        {
            this.array = null;
        }
        public FractionArray(PhanSo []a) {
            int a_length = a.length;
            this.array = new PhanSo [a_length];
            for(int i = 0 ; i < a_length ; i ++)
            {
                array[i] = a[i];
            }
        }

        public PhanSo getPhanSo(int pos)
        {
            if(pos < array.length)
                return array[pos];
            else
                return null;
        }

        public void setPhanSo(PhanSo a, int pos)
        {
            if(pos < array.length)
            {
                this.array[pos] = a;
            }
            else{
                System.out.println("Out of range");
            }
        }

        public void nhapMangPhanSo()
        {
            System.out.println("Nhap Mang: ");
            
            for(int i = 0 ; i < array.length ; i ++)
            {
                PhanSo a = new PhanSo();
                System.out.println("Phan tu " + i + " = ");
                a.nhapPhanSo();
                a.rutGonPhanSo();
                array[i] = a;
            }
        }

        public void xuatMangPhanSo(){
            for(int i = 0 ; i < array.length ; i ++)
            {
                System.out.print("Phan tu " + i + " = ");
                array[i].xuatPhanSo(); 
            }
        }

        public void tongCacPhanSo()
        {
            PhanSo a = new PhanSo();

            for(int i = 0 ; i < array.length ; i ++)
            {
                a.cong_2_PhanSo(array[i]);
            }

            System.out.print("tong cac phan so = ");
            a.xuatPhanSo();
        }

        public void tichCacPhanSo()
        {
            PhanSo a = new PhanSo();

            for(int i = 0 ; i < array.length ; i ++)
            {
                a.nhan_2_PhanSo(array[i]);
            }

            System.out.print("tong cac phan so = ");
            a.xuatPhanSo();
        }

        public PhanSo phanSoLonNhat()
        {
            PhanSo max = array[0];
            for(int i = 1 ; i < array.length ; i ++)
            {
                double a = (double)max.getTu()/max.getMau();
                double b = (double)array[i].getTu()/array[i].getMau();
                if(a < b)
                {
                    max = array[i];
                }

            }

            System.out.print("Phan so lon nhat la : ");
            max.xuatPhanSo();
            return max;
        }

        public void viTriCoPhanSoLonNhat() {
            PhanSo max = phanSoLonNhat();
            int count = 0;
            for(int i = 0 ; i < array.length; i ++)
            {
                if(array[i].getTu() == max.getTu() && array[i].getMau() == max.getMau())
                {
                    System.out.println("position :" + i);
                    count+=1;
                }
            }
            System.out.println("number of position: " + count);

        }

        public void rutGonMang() {
            for(int i = 0 ; i < array.length; i ++)
            {
                array[i].rutGonPhanSo();
            }
        }

        public void sortMangTangDan() {
            PhanSo temp = new PhanSo();
            for(int i = 0 ; i < array.length - 1; i ++)
            {
                double ps1 = (double)array[i].getTu()/array[i].getMau();

                for(int j = i + 1 ; j < array.length ; j ++)
                {
                    double ps2 = (double)array[j].getTu()/array[j].getMau();
                
                    if(ps1 > ps2)
                    {
                    
                        temp = array[j];
                        array[j] = array[i];
                        array[i]= temp;
                    }
                }
            }
            for(int i = 0 ; i < array.length ; i ++)
            {
                System.out.print("Phan tu " + i + " = ");
                array[i].xuatPhanSo(); 
            }
        }

        public void sortMangGiamDan() {
            PhanSo temp = new PhanSo();
            for(int i = 0 ; i < array.length - 1; i ++)
            {
                double ps1 = (double)array[i].getTu()/array[i].getMau();
               
                for(int j = i + 1 ; j < array.length ; j ++)
                {
                    double ps2 = (double)array[j].getTu()/array[j].getMau();
                    if(ps1 < ps2)
                    {
                        temp = array[j];
                        array[j] = array[i];
                        array[i]= temp;
                    }
                }
            }
            for(int i = 0 ; i < array.length ; i ++)
            {
                System.out.print("Phan tu " + i + " = ");
                array[i].xuatPhanSo(); 
            }
        }
        public void updatePhanTu(int k) {
            if(k < array.length && k >= 0)
            {
                PhanSo a = new PhanSo();
                a.nhapPhanSo();
                array[k] = a;
            }
        }

        public void themPhanSo(int k ) {
            PhanSo a = new PhanSo();
            a.nhapPhanSo();
            a.rutGonPhanSo();


            int tempIndex = array.length;
            
            PhanSo []tempArray = new PhanSo [tempIndex + 1];
            
            for(int i = 0 ; i < array.length ; i ++)
            {
                if(i < k - 1)
                {
                    tempArray[i] = array[i];
                }
                else if(i == k - 1)
                {
                    tempArray[i] = a;
                }
                else{
                    tempArray[i] = array[i - 1];
                }
            }
            
            FractionArray newArray = new FractionArray(tempArray);
            
            newArray.xuatMangPhanSo();
            
        }


        public void xoaPhanSo(int k) {
            int lengthArray = this.array.length;
            PhanSo []tempArray = new PhanSo [lengthArray - 1];
            for(int i = 0, j = 0 ; i < lengthArray ; i ++)
            {
                if(i == k)
                {
                    continue;
                }
                tempArray[j++] = array[i];
            }
            
            FractionArray newArray = new FractionArray(tempArray);
            newArray.xuatMangPhanSo();
            
        }    
    }
    public static void main(String[] args) {
        PhanSo [] a= new PhanSo [4];
        FractionArray array = new FractionArray(a);
        PhanSo b = new PhanSo(1,5);
        
        array.nhapMangPhanSo();
        array.xuatMangPhanSo();
        System.out.println("---------------------");
        
        array.getPhanSo(5).xuatPhanSo();
        array.setPhanSo(b, 2);
        System.out.println("---------------------");
        
        array.tichCacPhanSo();
        array.tongCacPhanSo();
        System.out.println("---------------------");
        
        array.phanSoLonNhat();
        array.viTriCoPhanSoLonNhat();
        System.out.println("---------------------");
        
        array.rutGonMang();
        array.sortMangTangDan();
        array.sortMangGiamDan();

        System.out.println("---------------------");
        array.updatePhanTu(3);
        array.themPhanSo(2);
        array.xoaPhanSo(4);
        
    }
}
