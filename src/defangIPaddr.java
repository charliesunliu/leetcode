class defangIPaddr {
    public String defangIPaddr(String address) {
        address.replaceAll(".", "[.]");
        return address;
    }
}