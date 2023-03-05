/* Класс ноутбуков */

package Seminar6;

public class Notebook {
    private String model; // модель
    private String brand; // бренд
    private Float diagonale; // диагональ экрана
    private String processor; // процессор
    private Integer memoryRAM; // объем ОЗУ
    private Integer memoryROM; // объем ПЗУ (жесткий диск)
    private String operationSystem; // установленная операционная система
    private String color; // цвет ноутбука
    private Float price; // цена

    public Notebook(String model, String brand, Float diagonale, String processor,
            Integer memoryRAM, Integer memoryROM, String operationSystem,
            String color, Float price) {
        this.model = model;
        this.brand = brand;
        this.diagonale = diagonale;
        this.processor = processor;
        this.memoryRAM = memoryRAM;
        this.memoryROM = memoryROM;
        this.operationSystem = operationSystem;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ноутбук, модель: " + model + "  / бренд: " + brand + "  / диагональ экрана: " + diagonale
        + "  / процессор: "+ processor + "  / оперативная память: " + memoryRAM + " Гб, объем SSD/диска: " + memoryROM
        + " Гб\n    / установленная операционная система: " + operationSystem + "  / цвет: " + color + "  // цена: " + price + " руб.";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((diagonale == null) ? 0 : diagonale.hashCode());
        result = prime * result + ((processor == null) ? 0 : processor.hashCode());
        result = prime * result + ((memoryRAM == null) ? 0 : memoryRAM.hashCode());
        result = prime * result + ((memoryROM == null) ? 0 : memoryROM.hashCode());
        result = prime * result + ((operationSystem == null) ? 0 : operationSystem.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (diagonale == null) {
            if (other.diagonale != null)
                return false;
        } else if (!diagonale.equals(other.diagonale))
            return false;
        if (processor == null) {
            if (other.processor != null)
                return false;
        } else if (!processor.equals(other.processor))
            return false;
        if (memoryRAM == null) {
            if (other.memoryRAM != null)
                return false;
        } else if (!memoryRAM.equals(other.memoryRAM))
            return false;
        if (memoryROM == null) {
            if (other.memoryROM != null)
                return false;
        } else if (!memoryROM.equals(other.memoryROM))
            return false;
        if (operationSystem == null) {
            if (other.operationSystem != null)
                return false;
        } else if (!operationSystem.equals(other.operationSystem))
            return false;
        if (color == null) {
            if (other.color != null)
                return false;
        } else if (!color.equals(other.color))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        return true;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Float getDiagonale() {
        return diagonale;
    }

    public String getProcessor() {
        return processor;
    }

    public Integer getMemoryRAM() {
        return memoryRAM;
    }

    public Integer getMemoryROM() {
        return memoryROM;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getColor() {
        return color;
    }

    public Float getPrice() {
        return price;
    }

    public Boolean byFilter(String model, String brand, Float diagonale, String processor,
            Integer memoryRAM, Integer memoryROM, String operationSystem,
            String color, Float price) {
        if (model != null)
            if (!this.model.contains(model))
                return false;
        if (brand != null)
            if (!this.brand.contains(brand))
                return false;
        if (diagonale < 0)
            if (this.diagonale != diagonale)
                return false;
        if (processor != null)
            if (!this.processor.contains(processor))
                return false;
        if (memoryRAM != 0)
            if (this.memoryRAM < memoryRAM)
                return false;
        if (memoryROM != 0)
            if (this.memoryROM < memoryROM)
                return false;
        if (operationSystem != null)
            if (!this.operationSystem.toLowerCase().contains(operationSystem.toLowerCase()))
                return false;
        if (color != null)
            if (!this.color.toLowerCase().contains(color.toLowerCase()))
                return false;
        if (price != 0)
            if (this.price <= price)
                return false;
        return true;
    }
}