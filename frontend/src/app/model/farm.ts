export interface Farm {
    id: string,
    cnpj: string,
    legalName: string,
    tradeName: string,
    address: {
        city: string,
        country: string,
        province: string,
        street: string,
        zipCode: string,
        number: number;
    },
    plots: [],
    createdDate: Date,
    lastModifiedDate: Date
}