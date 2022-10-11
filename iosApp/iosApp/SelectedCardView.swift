//
//  SelectedCardView.swift
//  iosApp
//
//  Created by Bruno Brito on 10/10/22.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SelectedCardView: View {
    
    @Binding var args: InfoModel
    
    var body: some View {
        ScrollView{
            VStack{
                Text(args.name)
                    .font(.title)
                    .fontWeight(.bold)
                let url = URL(string: args.card_images[0].image_url)
                let data = try? Data(contentsOf: url!)
                if let imageData = data {
                    let image = UIImage(data: imageData)
                    Image(uiImage: image!).resizable().frame(width: 300, height: 500)
                }
                Text(args.desc)
            }.padding(.all, 10)
        }
    }
}

/*struct SelectedCardView_Previews: PreviewProvider {
    static var previews: some View {
        SelectedCardView()
    }
}*/
